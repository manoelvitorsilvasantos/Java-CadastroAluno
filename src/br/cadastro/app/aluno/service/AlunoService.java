/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.aluno.service;

import br.cadastro.app.aluno.dao.AlunoDAO;
import br.cadastro.app.aluno.model.Aluno;
import br.cadastro.app.aluno.utils.ValidatorAluno;


/**
 *
 * @author mvictor
 */
public class AlunoService implements AlunoServiceInterface {
    private final AlunoDAO alunoDAO;
    private final ValidatorAluno val; 
            
    public AlunoService(){
        alunoDAO = new AlunoDAO();
        val = ValidatorAluno.getInstance();
    }
    
    @Override
    public boolean save(Aluno entity){
        boolean status = false;
        if(this.val.isValid(entity)){
            if(!this.alunoDAO.isExistsStudent(entity.getCpf())){
                this.alunoDAO.save(entity);
                status = true;
            }
        }
        return status;
    }  
    
    @Override
    public boolean update(Aluno entity){
        boolean status = false;
        if(this.val.isValid(entity)){
            if(!this.alunoDAO.isExistsStudent(entity.getCpf())){
                this.alunoDAO.update(entity);
                status = true;
            }
        }
        return status;
    }
    
    @Override
    public boolean delete(int id){
        boolean status = false;
        Aluno res = alunoDAO.findStudentById(id);
        if(res.getId() == id){
            this.alunoDAO.delete(id);
            status = true;
        }
        return status;
    }
}
