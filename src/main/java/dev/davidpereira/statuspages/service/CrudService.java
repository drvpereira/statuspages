package dev.davidpereira.statuspages.service;

import java.util.Optional;

public interface CrudService<T, ID> {

    Optional<T> findById(ID id);

}
