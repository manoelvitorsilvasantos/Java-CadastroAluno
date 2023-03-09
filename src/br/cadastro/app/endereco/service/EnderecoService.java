/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.endereco.service;

import br.cadastro.app.endereco.dao.EnderecoDAO;
import br.cadastro.app.endereco.utils.ValidatorEndereco;
import br.cadastro.app.model.Endereco;

/**
 *
 * @author mvictor
 */
public class EnderecoService implements EnderecoServiceInterface<Endereco>{
    private final EnderecoDAO enderecoDAO;
    private final ValidatorEndereco val; 
            
    public EnderecoService(){
        enderecoDAO = new EnderecoDAO();
        val = ValidatorEndereco.getInstance();
    }
    
    @Override
    public boolean save(Endereco entity){
        //cria um variavel para retorn true ou false
        boolean state = false;
        /*
            primeiramente verificamos se os campos estão preenchidos e se o cpf é valido.
        */
        if(!val.isNotValid(entity)){
            enderecoDAO.save(entity);
            state = true;
        }
        
        //retorna somente o estado.
        return state;
    }

    @Override
    public boolean update(Endereco entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
