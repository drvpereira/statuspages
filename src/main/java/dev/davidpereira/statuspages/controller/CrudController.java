package dev.davidpereira.statuspages.controller;

import dev.davidpereira.statuspages.exception.ResourceNotFoundException;
import dev.davidpereira.statuspages.mapper.PayloadMapper;
import dev.davidpereira.statuspages.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public abstract class CrudController<T, P, ID> {

    @Autowired
    private CrudService<T, ID> service;

    @Autowired
    private PayloadMapper<T, P> payloadMapper;

    @GetMapping("/{id}")
    public P get(@PathVariable("id") ID id) {
        Optional<T> searchedObject = service.findById(id);
        return searchedObject.map(payloadMapper::toPayload).orElseThrow(ResourceNotFoundException::new);
    }

}
