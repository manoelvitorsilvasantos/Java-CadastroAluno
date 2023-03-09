/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author mvictor
 */
public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/bdaluno";
    private static final String USUARIO = "mvictor";
    private static final String SENHA = "65564747";
    
    public static Connection criarConexao() {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (SQLException e) {
            System.out.println("Erro ao criar conexão com o banco de dados: " + e.getMessage());
        }
        return conexao;
    }
    
}
