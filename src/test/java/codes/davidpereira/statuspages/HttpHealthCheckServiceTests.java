package codes.davidpereira.statuspages;

import codes.davidpereira.statuspages.model.HealthCheckConfig;
import codes.davidpereira.statuspages.model.HealthCheckType;
import codes.davidpereira.statuspages.model.Status;
import codes.davidpereira.statuspages.service.checks.HttpHealthCheckService;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HttpHealthCheckServiceTests {

    @Test
    public void testSimpleRequestHealthCheckSuccess() {
        var config = HealthCheckConfig.builder()
                .type(HealthCheckType.HTTP)
                .url("https://www.google.com")
                .timeout(1000)
                .upStatus(HttpStatus.OK.value())
                .build();

        var service = new HttpHealthCheckService();
        var attempt = service.doHealthCheck(config);
        assertEquals(Status.OPERATIONAL, attempt.getStatus());
        assertNotNull(attempt.getTimestamp());
    }

    @Test
    public void testHealthCheckFailedDueToInvalidCertificate() {
        var config = HealthCheckConfig.builder()
                .type(HealthCheckType.HTTP)
                .url("https://mm.sodexo.io")
                .timeout(1000)
                .upStatus(HttpStatus.OK.value())
                .build();

        var service = new HttpHealthCheckService();
        var attempt = service.doHealthCheck(config);
        assertEquals(Status.OUTAGE, attempt.getStatus());
        assertNotNull(attempt.getTimestamp());
    }

    @Test
    public void testHealthCheckFailedDueToIncorrectStatusCode() {
        var config = HealthCheckConfig.builder()
                .type(HealthCheckType.HTTP)
                .url("https://yggdrasil-backend-dev.epassiaws.se/accounts/cardHolders")
                .timeout(1000)
                .upStatus(HttpStatus.OK.value())
                .build();

        var service = new HttpHealthCheckService();
        var attempt = service.doHealthCheck(config);
        assertEquals(Status.OUTAGE, attempt.getStatus());
        assertNotNull(attempt.getTimestamp());
    }

    @Test
    public void testHealthCheckFailedDueToTimeout() {
        var config = HealthCheckConfig.builder()
                .type(HealthCheckType.HTTP)
                .url("http://www.google.com:81/")
                .timeout(1000)
                .upStatus(HttpStatus.OK.value())
                .build();

        var service = new HttpHealthCheckService();
        var attempt = service.doHealthCheck(config);
        assertEquals(Status.OUTAGE, attempt.getStatus());
        assertNotNull(attempt.getTimestamp());
    }


}
