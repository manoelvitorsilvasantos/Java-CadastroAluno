/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.abstracts.implementacao;

import java.util.List;

/**
 *
 * @author mvictor
 * @param <T>
 */
public interface AbstractDAOInterface <T>{
    public void save(T entity);
    public void delete(int id);
    public void update(T entity);
    public List<T> listarAll();
}
