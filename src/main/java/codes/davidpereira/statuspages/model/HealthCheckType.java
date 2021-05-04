package codes.davidpereira.statuspages.model;

import codes.davidpereira.statuspages.service.HealthCheckService;
import codes.davidpereira.statuspages.service.checks.HttpHealthCheckService;

public enum HealthCheckType {

    HTTP(HttpHealthCheckService.class);

    private Class<? extends HealthCheckService> serviceClass;

    HealthCheckType(Class<? extends HealthCheckService> serviceClass) {
        this.serviceClass = serviceClass;
    }

}
