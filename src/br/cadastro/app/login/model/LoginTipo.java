/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.login.model;

/**
 *
 * @author mvictor
 */
public enum LoginTipo {
    
    /**
     *
     */
    Administrador("Administrador", 0),
    Aluno("Aluno", 1),
    Professor("Professor", 2);
    
    private final String nome;
    private final int valor;
    
    
    LoginTipo(String n, int v){
        nome = n; 
        valor = v;
    }
    
    public int getValor(){return valor;}
    public String getNome(){return nome;}
    @Override
    public String toString(){return nome + "("+valor + ")";}
}
