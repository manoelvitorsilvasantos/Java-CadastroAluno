/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.login.dao;

import br.cadastro.app.aluno.dao.AlunoDAO;
import br.cadastro.app.connect.ConnectionFactory;
import br.cadastro.app.login.model.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mvictor
 */
public class LoginDAO implements LoginDAOInterface{

    private final Connection connection;
    
    public LoginDAO(){
        this.connection = ConnectionFactory.criarConexao();
    }

    @Override
    public void save(Login entity) {
        String query = "INSERT INTO login (username, password, cpf, id_contatos, nivel) VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, entity.getUsername());
            ps.setString(2, entity.getPassword());
            ps.setString(3, entity.getCpf());
            ps.setInt(4, entity.getId_contatos());
            ps.setString(5, entity.getTipoConta());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Login entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Login> listarAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int findLoginByCpf(String cpf) {
        Login entity = null;
        String query = "SELECT  id, username, password, cpf, id_contatos, nivel FROM login WHERE cpf LIKE ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, cpf);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    entity = new Login();
                    entity.setId(rs.getInt("id"));
                    entity.setUsername(rs.getString("username"));
                    entity.setPassword(rs.getString("password"));
                    entity.setCpf(rs.getString("cpf"));
                    entity.setId_contatos(rs.getInt("id_contatos"));
                    entity.setTipoConta(rs.getString("nivel"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity.getId();
    }
    
    

    @Override
    public boolean isExistsLogin(Login entity) {
        Login login = null;
        boolean state = false;
        String query = "SELECT username, password  FROM login WHERE username LIKE ? AND password LIKE ?";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, entity.getUsername());
            ps.setString(2, entity.getPassword());
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    login = new Login();
                    login.setUsername(rs.getString("username"));
                    login.setPassword(rs.getString("password"));
                    
                    state = entity.getUsername().equals(login.getUsername()) && entity.getPassword().equals(login.getPassword());
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return state;
    }

    @Override
    public Login findLoginById(int id) {
        Login entity = null;
        String query = "SELECT nome, cpf FROM pessoa WHERE id =?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    entity = new Login();
                    entity.setId(rs.getInt("id"));
                    entity.setUsername(rs.getString("username"));
                    entity.setPassword(rs.getString("password"));
                    entity.setCpf(rs.getString("cpf"));
                    entity.setId_contatos(rs.getInt("id_contatos"));
                    entity.setTipoConta(rs.getString("nivel"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity;
    }
    
}
