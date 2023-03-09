/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.login.utils;

import br.cadastro.app.login.model.Login;
import br.cadastro.app.utils.ValidatorAbstract;
import javax.swing.JTextField;

/**
 *
 * @author mvictor
 */
public class ValidatorLogin extends ValidatorAbstract<Login>{
    
    private static ValidatorLogin instance;
    
    private ValidatorLogin(){}
    
    public static ValidatorLogin getInstance(){
        if(instance == null){
            instance = new ValidatorLogin();
        }
        return instance;
    }
    
    
    @Override
    public boolean isNotValid(Login entity) {
       return entity == null;
    }

    @Override
    public boolean isValid(Login entity) {
        return entity != null;
    }
    
    

 

    
    
}
