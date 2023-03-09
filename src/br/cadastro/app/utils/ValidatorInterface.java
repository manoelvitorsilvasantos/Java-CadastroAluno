/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.utils;

/**
 *
 * @author mvictor
 * @param <T>
 */
public interface ValidatorInterface <T>{
    public void isEmtptyRG(javax.swing.JFormattedTextField rg);
    public void isEmptyCPF(javax.swing.JFormattedTextField cpf);
    public void isEmptyCelular(javax.swing.JFormattedTextField celular);
    public void isEmptyTelefone(javax.swing.JFormattedTextField telefone);
    public void isEmptyCep(javax.swing.JFormattedTextField cep);
    public void isFieldEmpty(javax.swing.JTextField campo);
    public boolean isEmpty(String texto);
    public boolean isNotEmpty(String texto);
}
