package dev.davidpereira.statuspages.controller;

import dev.davidpereira.statuspages.exception.ResourceNotFoundException;
import dev.davidpereira.statuspages.mapper.PayloadMapper;
import dev.davidpereira.statuspages.model.Persistable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public abstract class CrudController<T extends Persistable<ID>, P, ID> {

    @Autowired
    private JpaRepository<T, ID> repository;

    @Autowired
    private PayloadMapper<T, P> payloadMapper;

    @Autowired
    private RepresentationModelAssembler<P, EntityModel<P>> modelAssembler;

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<P>> getOne(@PathVariable("id") ID id) {
        Optional<T> searchedObject = repository.findById(id);
        return searchedObject
                .map(payloadMapper::toPayload)
                .map(modelAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @GetMapping("/")
    public ResponseEntity<CollectionModel<EntityModel<P>>> getAll() {
        List<T> searchedObject = repository.findAll();
        return ResponseEntity.ok(modelAssembler.toCollectionModel(searchedObject.stream()
                .map(payloadMapper::toPayload).collect(toList())));
    }

    @PostMapping("/")
    public P create(@RequestBody P payload) {
        T entity = payloadMapper.fromPayload(payload);
        return payloadMapper.toPayload(repository.save(entity));
    }

    @PutMapping("/{id}")
    public P update(@PathVariable("id") ID id, @RequestBody P payload) {
        repository.findById(id);
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") ID id) {
        repository.deleteById(id);
    }

}
