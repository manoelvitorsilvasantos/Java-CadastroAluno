/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.endereco.dao;

import br.cadastro.app.connect.ConnectionFactory;
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
public class EnderecoDAO implements EnderecoDAOInterface{
    
    private final Connection connection;
    
    public EnderecoDAO(){
        this.connection = ConnectionFactory.criarConexao();
    }

    @Override
    public void save(Endereco entity) {
        String query = "INSERT INTO endereco (logradouro, bairro, complemento, numero, cep, cidade, uf, aluno_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, entity.getLogradouro());
            ps.setString(2, entity.getBairro());
            ps.setString(3, entity.getComplemento());
            ps.setInt(4, entity.getNumero());
            ps.setString(5, entity.getCep());
            ps.setString(6, entity.getCidade());
            ps.setString(7, entity.getUf());
            ps.setInt(8, entity.getAluno_id());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM endereco WHERE aluno_id = ?";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Endereco entity) {
        String query = "UPDATE endereco SET logradouro=?, bairro=?, complemento=?, numero=?, cep=?, cidade=?, uf=?  WHERE aluno_id=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, entity.getLogradouro());
            ps.setString(2, entity.getBairro());
            ps.setString(3, entity.getComplemento());
            ps.setInt(4, entity.getNumero());
            ps.setString(5, entity.getCep());
            ps.setString(6, entity.getCidade());
            ps.setString(7, entity.getUf());
            ps.setInt(8, entity.getAluno_id());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Endereco> listarAll() {
        List<Endereco> endereco = new ArrayList<>();
        String query = "SELECT id, logradouro, bairro, complemento, numero, cep, cidade, uf, aluno_id FROM endereco";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Endereco e = new Endereco();
                    e.setLogradouro(rs.getString("logradouro"));
                    e.setBairro(rs.getString("bairro"));
                    e.setComplemento(rs.getString("complemento"));
                    e.setNumero(rs.getInt("numero"));
                    e.setCep(rs.getString("cep"));
                    e.setCidade(rs.getString("cidade"));
                    e.setUf(rs.getString("uf"));
                    e.setAluno_id(rs.getInt("aluno_id"));
                    endereco.add(e);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return endereco;
    }

    @Override
    public Endereco findByAlunoId(int id) {
        Endereco endereco = null;
        String query = "SELECT id, logradouro, bairro, complemento, numero, cep, cidade, uf, aluno_id FROM endereco WHERE aluno_id =?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    endereco = new Endereco();
                    endereco.setId(rs.getInt("id"));
                    endereco.setLogradouro(rs.getString("logradouro"));
                    endereco.setBairro(rs.getString("bairro"));
                    endereco.setComplemento(rs.getString("complemento"));
                    endereco.setNumero(rs.getInt("numero"));
                    endereco.setCidade(rs.getString("cidade"));
                    endereco.setUf(rs.getString("uf"));
                    endereco.setAluno_id(rs.getInt("aluno_id"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return endereco;
    }
    
}
