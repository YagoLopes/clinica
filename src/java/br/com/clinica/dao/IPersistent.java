/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.clinica.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author lenovo
 */
public interface IPersistent<T> {

    public void save(T entity) throws SQLException;

    public void delete(T entity) throws SQLException;

    public void delete(int id) throws SQLException;

    public void update(T entity) throws SQLException;

    public T find(int id) throws SQLException;

    public List<T> findAll() throws SQLException;
}
