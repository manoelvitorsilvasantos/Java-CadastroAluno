/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.utils;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.border.Border;


/**
 *
 * @author mvictor
 */
public class Validator implements ValidatorInterface{
    
    private static Validator instance = null;
    private final Border green;
    private final Border red;
    
    private Validator(){
        this.red = BorderFactory.createLineBorder(Color.RED);
        this.green = BorderFactory.createLineBorder(Color.GREEN);
    }
    
    public static Validator getInstance(){
        if(instance == null){
            instance = new Validator();
        }
        return instance;
    }


    @Override
    public void isFieldEmpty(JTextField field) {
        if(field.getText().isEmpty()){
            field.setBorder(red);
        }
        else{
            field.setBorder(green);
        }
    }
    
    @Override
    public boolean isEmpty(final String texto) {
        return texto.isEmpty();
    }
    
    @Override
    public boolean isNotEmpty(final String texto) {
        return !texto.isEmpty();
    }

    @Override
    public void isEmtptyRG(final JFormattedTextField rg) {
        if(rg.getText().length() > 14){
            rg.setBorder(red);
        }
        else{
            rg.setBorder(red);
        }
    }

    @Override
    public void isEmptyCPF(final JFormattedTextField cpf){
       if(!cpf.getText().replaceAll("\\.", "").replaceAll("-", "").trim().isEmpty()){
           cpf.setBorder(green);
       }
       else{
           cpf.setBorder(red);
       }
    }

    @Override
    public void isEmptyCelular(final JFormattedTextField celular) {
        if(!celular.getText().replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("-", "").replaceAll("-", "").trim().isEmpty()){
           celular.setBorder(green);
       }
       else{
           celular.setBorder(red);
       }
    }

    @Override
    public void isEmptyTelefone(final JFormattedTextField telefone) {
        if(!telefone.getText().replaceAll("\\(", "").replaceAll("\\)", "").replaceAll("-", "").trim().isEmpty()){
           telefone.setBorder(green);
       }
       else{
           telefone.setBorder(red);
       }
    }

    @Override
    public void isEmptyCep(final JFormattedTextField cep) {
        if(!cep.getText().replaceAll("-", "").trim().isEmpty()){
           cep.setBorder(green);
       }
       else{
           cep.setBorder(red);
       }
    }

  

  

  

   
    
}
