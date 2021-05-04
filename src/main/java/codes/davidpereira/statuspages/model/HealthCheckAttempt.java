package codes.davidpereira.statuspages.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HealthCheckAttempt {

    private HealthCheckType type;

    private LocalDateTime timestamp;

    private Status status;

    public static HealthCheckAttempt operational() {
        var attempt = new HealthCheckAttempt();
        attempt.setStatus(Status.OPERATIONAL);
        attempt.setTimestamp(LocalDateTime.now());
        return attempt;
    }

    public static HealthCheckAttempt outage() {
        var attempt = new HealthCheckAttempt();
        attempt.setStatus(Status.OUTAGE);
        attempt.setTimestamp(LocalDateTime.now());
        return attempt;
    }

}
