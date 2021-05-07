package codes.davidpereira.statuspages.service;

import codes.davidpereira.statuspages.model.HealthCheckAttempt;
import codes.davidpereira.statuspages.model.HttpHealthCheckConfig;

public interface HealthCheckService {

    HealthCheckAttempt doHealthCheck(HttpHealthCheckConfig config);

}
