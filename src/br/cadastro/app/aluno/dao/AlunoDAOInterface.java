/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.aluno.dao;

import br.cadastro.app.abstracts.implementacao.AbstractDAOInterface;
import br.cadastro.app.aluno.model.Aluno;

/**
 *
 * @author mvictor
 */
interface AlunoDAOInterface extends AbstractDAOInterface<Aluno>{
    public Aluno findStudentById(int id);
    public Aluno findByCpf(String cpf);
    public int findStudentByCpf(String cpf);
    public boolean isExistsStudent(String cpf);
}
