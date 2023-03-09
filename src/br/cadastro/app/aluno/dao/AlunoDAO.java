/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.aluno.dao;

import br.cadastro.app.aluno.model.Aluno;
import br.cadastro.app.connect.ConnectionFactory;
import br.cadastro.app.model.Contatos;
import br.cadastro.app.model.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mvictor
 */
public class AlunoDAO implements AlunoDAOInterface{
    
    private final Connection connection;
    
    public AlunoDAO (){
        this.connection = ConnectionFactory.criarConexao();
    }

    /**
     *
     * @param entity
     */
    @Override
    public void save(Aluno entity){
        String query = "INSERT INTO aluno (nome, cpf) VALUES (?, ?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, entity.getNome());
            ps.setString(2, entity.getCpf());
            ps.executeUpdate();
            ps.close();
            System.out.println("Status [AlunoDAO]: Foi Salvo.");
        } catch (SQLException ex) {
            System.out.println("Status [AlunoDAO]: Houve um error.");
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM Aluno WHERE id = ?";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Aluno entity) {
        String query = "UPDATE aluno SET nome=?, cpf=? WHERE id=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, entity.getNome());
            ps.setString(2, entity.getCpf());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Aluno> listarAll() {
        List<Aluno> aluno = new ArrayList<>();
        String query = "SELECT id, nome, cpf FROM aluno";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Aluno al = new Aluno();
                    al.setId(rs.getInt("id"));
                    al.setNome(rs.getString("nome"));
                    al.setCpf(rs.getString("cpf"));
                    aluno.add(al);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aluno;
    }

    @Override
    public Aluno findStudentById(int id) {
        Aluno aluno = null;
        String query = "SELECT nome, cpf FROM pessoa WHERE id =?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    aluno = new Aluno();
                    aluno.setId(rs.getInt("id"));
                    aluno.setNome(rs.getString("nome"));
                    aluno.setCpf(rs.getString("cpf"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aluno;
    }

    
    @Override
    public int findStudentByCpf(String cpf) {
        Aluno aluno = null;
        String query = "SELECT id, nome, cpf FROM aluno WHERE cpf LIKE ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, cpf);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    aluno = new Aluno();
                    aluno.setId(rs.getInt("id"));
                    aluno.setNome(rs.getString("nome"));
                    aluno.setCpf(rs.getString("cpf"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aluno.getId();
    }

    @Override
    public boolean isExistsStudent(String cpf) {
        boolean state = false;
        String query = "SELECT cpf  FROM aluno WHERE cpf LIKE ?";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, cpf);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    Aluno aluno = new Aluno();
                    aluno.setCpf(rs.getString("cpf"));
                    state = cpf.equals(aluno.getCpf());
                    System.out.println("Seu status = " +state);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state;
    }

    @Override
    public Aluno findByCpf(String cpf) {
        Aluno aluno = null;
        String query = "SELECT * FROM aluno a JOIN contatos c ON c.aluno_id = a.id JOIN endereco e ON e.aluno_id = a.id WHERE cpf =?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, cpf);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    aluno = new Aluno();
                    aluno.setId(rs.getInt("a.id"));
                    aluno.setNome(rs.getString("a.nome"));
                    aluno.setCpf(rs.getString("a.cpf"));
                    Contatos contatos = new Contatos();
                    contatos.setCelular(rs.getString("c.celular"));
                    contatos.setTelefone(rs.getString("c.telefone"));
                    contatos.setEmail(rs.getString("c.email"));
                    contatos.setAluno_id(rs.getInt("c.aluno_id"));
                    Endereco endereco = new Endereco();
                    endereco.setLogradouro(rs.getString("e.logradouro"));
                    endereco.setBairro(rs.getString("e.bairro"));
                    endereco.setCep(rs.getString("e.cep"));
                    endereco.setCidade(rs.getString("e.cidade"));
                    endereco.setUf(rs.getString("e.uf"));
                    endereco.setComplemento(rs.getString("e.complemento"));
                    endereco.setNumero(rs.getInt("e.numero"));
                    endereco.setAluno_id(rs.getInt("e.aluno_id"));
                    aluno.setContatos(contatos);
                    aluno.setEndereco(endereco);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aluno;
    }
    
    
}
