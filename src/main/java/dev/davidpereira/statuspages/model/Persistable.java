package dev.davidpereira.statuspages.model;

import java.util.Optional;

public interface Persistable<ID> {

    Optional<ID> getOptionalId();

}
