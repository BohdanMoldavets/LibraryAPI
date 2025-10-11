package com.moldavets.library.service;

import java.util.List;

public interface CrudService<T> {

    T getById(Long id);
    List<T> getAll();
    T save(T object);
    T update(Long id, T object);
    void delete(Long id);

}
