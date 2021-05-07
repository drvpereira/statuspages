package codes.davidpereira.statuspages;

import codes.davidpereira.statuspages.model.HealthStatus;
import codes.davidpereira.statuspages.model.HttpHealthCheckConfig;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HttpHealthCheckServiceTests {

    @Test
    public void testSimpleRequestHealthCheckSuccess() {
        var config = HttpHealthCheckConfig.builder()
                .url("https://www.google.com")
                .timeout(1000)
                .upStatus(HttpStatus.OK.value())
                .build();

        var attempt = config.doHealthCheck();
        assertEquals(HealthStatus.OPERATIONAL, attempt.getStatus());
        assertNotNull(attempt.getTimestamp());
    }

    @Test
    public void testHealthCheckFailedDueToInvalidCertificate() {
        var config = HttpHealthCheckConfig.builder()
                .url("https://mm.sodexo.io")
                .timeout(1000)
                .upStatus(HttpStatus.OK.value())
                .build();

        var attempt = config.doHealthCheck();
        assertEquals(HealthStatus.OUTAGE, attempt.getStatus());
        assertNotNull(attempt.getTimestamp());
    }

    @Test
    public void testHealthCheckFailedDueToIncorrectStatusCode() {
        var config = HttpHealthCheckConfig.builder()
                .url("https://yggdrasil-backend-dev.epassiaws.se/accounts/cardHolders")
                .timeout(1000)
                .upStatus(HttpStatus.OK.value())
                .build();

        var attempt = config.doHealthCheck();
        assertEquals(HealthStatus.OUTAGE, attempt.getStatus());
        assertNotNull(attempt.getTimestamp());
    }

    @Test
    public void testHealthCheckFailedDueToTimeout() {
        var config = HttpHealthCheckConfig.builder()
                .url("http://www.google.com:81/")
                .timeout(1000)
                .upStatus(HttpStatus.OK.value())
                .build();

        var attempt = config.doHealthCheck();
        assertEquals(HealthStatus.OUTAGE, attempt.getStatus());
        assertNotNull(attempt.getTimestamp());
    }


}
