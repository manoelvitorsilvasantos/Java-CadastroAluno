/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.login.service;

import br.cadastro.app.login.dao.LoginDAO;
import br.cadastro.app.login.model.Login;
import br.cadastro.app.login.utils.ValidatorLogin;
import br.cadastro.app.utils.Validator;

/**
 *
 * @author mvictor
 */
public class LoginService {
    
    private final LoginDAO loginDAO;
    private final ValidatorLogin val;
    private final Validator v;
    
    
    public LoginService(){
        this.loginDAO = new LoginDAO();
        this.val = ValidatorLogin.getInstance();
        this.v = Validator.getInstance();
    }
    
    public boolean save(Login entity){
        boolean state = false;
        if(val.isNotValid(entity) && val.validarCPF(val.removeDotsOnlyNumbers(entity.getCpf()))){
            //verifica se o usuário nao existe na base de dados.
            //se retorna verdadeiro então salva a informacao e guardo o state como true
            if(loginDAO.isExistsLogin(entity)){
                loginDAO.save(entity);
                state = true;
            }
        }
        return state;
    }
    
    public boolean logar(Login entity){
        boolean state = false;
        if(v.isNotEmpty(entity.getUsername()) && v.isNotEmpty(entity.getPassword())){
            state = loginDAO.isExistsLogin(entity);
        }
        return state;
    }
    
    
}
