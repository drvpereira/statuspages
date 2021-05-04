package codes.davidpereira.statuspages.service;

import codes.davidpereira.statuspages.model.HealthCheckAttempt;
import codes.davidpereira.statuspages.model.HealthCheckConfig;

public interface HealthCheckService {

    HealthCheckAttempt doHealthCheck(HealthCheckConfig config);

}
