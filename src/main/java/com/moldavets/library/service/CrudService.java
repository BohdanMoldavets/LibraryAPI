package com.moldavets.library.service;

import java.util.List;

public interface CrudService<T, R> {

    R getById(Long id);
    List<R> getAll();
    R save(T object);
    R update(Long id, T object);
    void delete(Long id);

}
