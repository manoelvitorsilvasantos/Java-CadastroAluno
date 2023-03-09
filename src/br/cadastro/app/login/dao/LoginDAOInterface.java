/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.login.dao;

import br.cadastro.app.abstracts.implementacao.AbstractDAOInterface;
import br.cadastro.app.login.model.Login;

/**
 *
 * @author mvictor
 */
public interface LoginDAOInterface extends AbstractDAOInterface <Login>{
    public Login findLoginById(int id);
    public int findLoginByCpf(String cpf);
    public boolean isExistsLogin(Login entity);
   
  
}
