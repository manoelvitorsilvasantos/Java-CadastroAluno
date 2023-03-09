/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.contatos.dao;

import br.cadastro.app.abstracts.implementacao.AbstractDAOInterface;
import br.cadastro.app.model.Contatos;

/**
 *
 * @author mvictor
 */
interface ContatosDAOInterface extends AbstractDAOInterface <Contatos>{
    public Contatos findByAlunoId(int id);
}
