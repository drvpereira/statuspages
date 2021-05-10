package dev.davidpereira.statuspages.service.impl;

import dev.davidpereira.statuspages.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public abstract class CrudServiceImpl<T, ID> implements CrudService<T, ID> {

    @Autowired
    private CrudRepository<T, ID> repository;

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

}
