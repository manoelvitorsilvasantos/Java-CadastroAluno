/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.contatos.service;

import br.cadastro.app.contatos.dao.ContatosDAO;
import br.cadastro.app.contatos.utils.ValidatorContatos;
import br.cadastro.app.model.Contatos;

/**
 *
 * @author mvictor
 */
public class ContatosService implements ContatosServiceInterface <Contatos>{
    private final ContatosDAO contatosDAO;
    private final ValidatorContatos val; 
            
    public ContatosService(){
        contatosDAO = new ContatosDAO();
        val = ValidatorContatos.getInstance();
    }
    
    /**
     * @param entity - Dados a serem salvos.
     * @return save - Retorna true se as informações foram salvas, caso contrário false.
     */
    
    @Override
    public boolean save(Contatos entity){
        boolean state = false;
        if(!this.val.isNotValid(entity)){
            this.contatosDAO.save(entity);
            state = true;
        }
        return state;
    }
    
    @Override
    public boolean update(Contatos entity){
        boolean status = false;
        return status;
    }
    
    @Override
    public boolean delete(int id){
        boolean status = false;
        Contatos contatos = contatosDAO.findByAlunoId(id);
        if(contatos.getAluno_id() == id){
            this.contatosDAO.delete(id);
            status = true;
        }
        return status;
    }
    
}
