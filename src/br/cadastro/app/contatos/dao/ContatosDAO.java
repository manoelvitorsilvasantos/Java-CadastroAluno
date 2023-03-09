/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.contatos.dao;

import br.cadastro.app.connect.ConnectionFactory;
import br.cadastro.app.model.Contatos;
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
public class ContatosDAO implements ContatosDAOInterface{
    
    private final Connection connection;
    
    public ContatosDAO (){
        this.connection = ConnectionFactory.criarConexao();
    }
    
    @Override
    public void save(Contatos entity) {
        String query = "INSERT INTO contatos (telefone, celular, email, aluno_id) VALUES (?, ?, ?, ?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, entity.getTelefone());
            ps.setString(2, entity.getCelular());
            ps.setString(3, entity.getEmail());
            ps.setInt(4, entity.getAluno_id());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM contatos WHERE aluno_id = ?";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Contatos entity) {
        String query = "UPDATE contatos SET telefone=?, celular=?, email=? WHERE aluno_id=?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, entity.getTelefone());
            ps.setString(2, entity.getCelular());
            ps.setString(3, entity.getEmail());
            ps.setInt(4, entity.getAluno_id());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Contatos> listarAll() {
        List<Contatos> contatos = new ArrayList<>();
        String query = "SELECT id, telefone, celular, email, aluno_id FROM contatos";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Contatos c = new Contatos();
                    c.setId(rs.getInt("id"));
                    c.setTelefone(rs.getString("telefone"));
                    c.setCelular(rs.getString("celular"));
                    c.setEmail(rs.getString("email"));
                    c.setAluno_id(rs.getInt("aluno_id"));
                    contatos.add(c);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contatos;
    }

    @Override
    public Contatos findByAlunoId(int id) {
        Contatos contatos = null;
        String query = "SELECT id, telefone, celular, email, aluno_id FROM endereco WHERE aluno_id =?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    contatos = new Contatos();
                    contatos.setId(rs.getInt("id"));
                    contatos.setTelefone(rs.getString("telefone"));
                    contatos.setCelular(rs.getString("celular"));
                    contatos.setEmail(rs.getString("email"));
                    contatos.setAluno_id(rs.getInt("aluno_id"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contatos;
    }
    
}
