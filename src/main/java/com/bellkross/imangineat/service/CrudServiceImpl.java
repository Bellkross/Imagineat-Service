package com.bellkross.imangineat.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Objects;
import java.util.Optional;

public class CrudServiceImpl<T, ID> implements CrudService<T, ID> {

    protected JpaRepository<T, ID> repository;

    CrudServiceImpl(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public <S extends T> S save(S entity) {
        Objects.requireNonNull(entity);
        return repository.save(entity);
    }

    @Override
    public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
        Objects.requireNonNull(entities);
        for (S e : entities) {
            Objects.requireNonNull(e);
        }
        return repository.saveAll(entities);
    }

    @Override
    public Optional<T> getById(ID id) {
        Objects.requireNonNull(id);
        return repository.findById(id);
    }

    @Override
    public boolean existsById(ID id) {
        Objects.requireNonNull(id);
        return repository.existsById(id);
    }

    @Override
    public Iterable<T> getAll() {
        return repository.findAll();
    }

    @Override
    public Iterable<T> getAllById(Iterable<ID> ids) {
        return repository.findAllById(ids);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    @Override
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Override
    public void deleteAll(Iterable<? extends T> entities) {
        for (T entity : entities) {
            delete(entity);
        }
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
