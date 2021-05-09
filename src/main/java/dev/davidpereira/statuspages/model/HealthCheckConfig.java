package dev.davidpereira.statuspages.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class HealthCheckConfig {

    @Id
    private Long id;

    private String type;

    abstract HealthCheckAttempt doHealthCheck();

}
