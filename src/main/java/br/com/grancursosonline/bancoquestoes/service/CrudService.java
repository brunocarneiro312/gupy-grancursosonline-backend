package br.com.grancursosonline.bancoquestoes.service;

import java.io.Serializable;
import java.util.Collection;

public interface CrudService<T extends Serializable> {

    /**
     * Create
     */
    T save(T t);

    /**
     * Read
     */
    T getById(Integer id);

    Collection<T> list();

    /**
     * Update
     */
    T update(T t);

    /**
     * Delete
     */
    T delete(Integer id);
}
