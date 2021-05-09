package dev.davidpereira.statuspages.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class HealthCheckAttempt {

    private HealthCheckConfig config;

    private LocalDateTime timestamp;

    private HealthStatus status;

    public static HealthCheckAttempt operational() {
        var attempt = new HealthCheckAttempt();
        attempt.status = HealthStatus.OPERATIONAL;
        attempt.timestamp = LocalDateTime.now();
        return attempt;
    }

    public static HealthCheckAttempt outage() {
        var attempt = new HealthCheckAttempt();
        attempt.status = HealthStatus.OUTAGE;
        attempt.timestamp = LocalDateTime.now();
        return attempt;
    }

}
