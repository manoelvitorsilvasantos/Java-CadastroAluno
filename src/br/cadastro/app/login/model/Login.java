/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.login.model;

import br.cadastro.app.abstracts.model.AbstractModel;

/**
 *
 * @author mvictor
 */
public class Login extends AbstractModel{
    
    private String username;
    private String password;
    private String cpf;
    private int id_contatos;
    private String nivel;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }



    public int getId_contatos() {
        return id_contatos;
    }

    public void setId_contatos(int id_contatos) {
        this.id_contatos = id_contatos;
    }

    public String getTipoConta() {
        return nivel;
    }

    public void setTipoConta(String tipoConta) {
        this.nivel = tipoConta;
    }


 
    
}
