package codes.davidpereira.statuspages.model;

import java.time.LocalDateTime;

public class HealthCheckEvent {

    private HealthCheck type;

    private LocalDateTime timestamp;

    private Status status;

}
