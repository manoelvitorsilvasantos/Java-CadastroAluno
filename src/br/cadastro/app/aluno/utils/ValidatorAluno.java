/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.aluno.utils;

import br.cadastro.app.aluno.model.Aluno;
import br.cadastro.app.utils.ValidatorAbstract;
import javax.swing.JTextField;

/**
 *
 * @author mvictor
 */
public class ValidatorAluno extends ValidatorAbstract <Aluno>{

    private static ValidatorAluno instance;
    
    private ValidatorAluno(){}
    
    public static ValidatorAluno getInstance(){
        if(instance == null){
            instance = new ValidatorAluno();
        }
        return instance;
    }
    
    @Override
    public boolean isNotValid(Aluno entity) {
        return entity == null;
    }

    @Override
    public boolean isValid(Aluno entity) {
        return entity != null;
    }
  
    
}
