package dev.davidpereira.statuspages.service;

import dev.davidpereira.statuspages.model.HealthCheckAttempt;
import dev.davidpereira.statuspages.model.HttpHealthCheckConfig;

public interface HealthCheckService {

    HealthCheckAttempt doHealthCheck(HttpHealthCheckConfig config);

}
