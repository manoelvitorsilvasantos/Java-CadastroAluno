package br.app.view;


import br.cadastro.app.aluno.dao.AlunoDAO;
import br.cadastro.app.aluno.model.Aluno;
import br.cadastro.app.model.PessoaFisica;
import br.cadastro.app.aluno.service.AlunoService;
import br.cadastro.app.aluno.utils.ValidatorAluno;
import java.awt.Component;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mvictor
 */
public class Main {

    public static void main(String args[]){
        
        ValidatorAluno val = ValidatorAluno.getInstance();
        AlunoService as = new AlunoService();
        boolean status = false;
        Aluno aluno = new Aluno();
        aluno.setNome("manuel vitor");
        aluno.setCpf("054.763.035-29");
        status = as.save(aluno);
        if(val.isNotValid(aluno)){
            System.out.println(status);
        }else{
            System.out.println(status);
        }
    }
}
