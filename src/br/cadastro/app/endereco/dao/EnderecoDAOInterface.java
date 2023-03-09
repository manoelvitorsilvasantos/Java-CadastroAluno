/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.endereco.dao;

import br.cadastro.app.abstracts.implementacao.AbstractDAOInterface;
import br.cadastro.app.model.Endereco;

/**
 *
 * @author mvictor
 */
interface EnderecoDAOInterface extends AbstractDAOInterface <Endereco>{
    public Endereco findByAlunoId(int id);
}
