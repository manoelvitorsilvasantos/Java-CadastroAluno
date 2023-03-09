/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.app.view.dadosPessoais.dao;

import br.cadastro.app.aluno.model.Aluno;
import br.cadastro.app.model.Contatos;
import br.cadastro.app.model.Endereco;

/**
 *
 * @author mvictor
 * @param <T>
 */
public interface DadosPessoaisDAOInterface{
    public boolean saveDadosPessoais(Aluno aluno, Contatos contatos, Endereco endereco);
    public boolean updateDadosPessoais(Aluno aluno, Contatos contatos, Endereco endereco);
}
