package dev.davidpereira.statuspages.model;

import javax.persistence.*;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class HealthCheckConfig implements Persistable<Long> {

    @Id
    private Long id;

    private String type;

    abstract HealthCheckAttempt doHealthCheck();

    @Override
    public Optional<Long> getId() {
        return ofNullable(id);
    }
}
