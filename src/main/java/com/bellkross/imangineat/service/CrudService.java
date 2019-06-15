package com.bellkross.imangineat.service;

import java.util.Optional;

public interface CrudService<T, ID> {

    <S extends T> S save(S entity);
    <S extends T> Iterable<S> saveAll(Iterable<S> entities);
    Optional<T> getById(ID id);
    boolean existsById(ID id);
    Iterable<T> getAll();
    Iterable<T> getAllById(Iterable<ID> ids);
    long count();
    void deleteById(ID id);
    void delete(T entity);
    void deleteAll(Iterable<? extends T> entities);
    void deleteAll();

}
