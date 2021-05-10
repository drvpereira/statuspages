package dev.davidpereira.statuspages.service.impl;

import dev.davidpereira.statuspages.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class CrudServiceImpl<T, ID> implements CrudService<T, ID> {

    @Autowired
    private JpaRepository<T, ID> repository;

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public List<T> findAll() {
        return repository.findAll();
    }

}
