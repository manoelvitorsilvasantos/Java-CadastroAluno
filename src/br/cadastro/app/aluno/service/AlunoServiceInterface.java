/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.aluno.service;

import br.cadastro.app.aluno.model.Aluno;

/**
 *
 * @author mvictor
 */
public interface AlunoServiceInterface {
    boolean delete(int id);
    boolean save(Aluno entity);
    boolean update(Aluno entity);
}
