/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.contatos.utils;

import br.cadastro.app.model.Contatos;
import br.cadastro.app.utils.ValidatorAbstract;
import javax.swing.JTextField;

/**
 *
 * @author mvictor
 */
public class ValidatorContatos extends ValidatorAbstract<Contatos>{
    
    private static ValidatorContatos instance;
    
    private ValidatorContatos(){}
    
    public static ValidatorContatos getInstance(){
        if(instance == null){
            instance = new ValidatorContatos();
        }
        return instance;
    }
    
    

    @Override
    public boolean isNotValid(Contatos entity) {
       return entity == null;
    }

    @Override
    public boolean isValid(Contatos entity) {
        return entity != null;
    }
}

