/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cadastro.app.endereco.service;

/**
 *
 * @author mvictor
 */
interface EnderecoServiceInterface <T> {
    public boolean save(T entity);
    public boolean update(T entity);
    public boolean delete(int id);
}
