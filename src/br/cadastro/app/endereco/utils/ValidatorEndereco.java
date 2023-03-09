/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.endereco.utils;

import br.cadastro.app.model.Endereco;
import br.cadastro.app.utils.ValidatorAbstract;
import javax.swing.JTextField;

/**
 *
 * @author mvictor
 */
public class ValidatorEndereco extends ValidatorAbstract<Endereco>{
    
    private static ValidatorEndereco instance;
    
    private ValidatorEndereco(){}
    
    public static ValidatorEndereco getInstance(){
        if(instance == null){
            instance = new ValidatorEndereco();
        }
        return instance;
    }
    
    
    @Override
    public boolean isNotValid(Endereco entity) {
       return entity == null;
    }

    @Override
    public boolean isValid(Endereco entity) {
        return entity != null;
    }
    
}
