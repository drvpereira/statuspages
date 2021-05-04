package codes.davidpereira.statuspages.service.checks;

import codes.davidpereira.statuspages.model.HealthCheckAttempt;
import codes.davidpereira.statuspages.model.HealthCheckConfig;
import codes.davidpereira.statuspages.service.HealthCheckService;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;

import static codes.davidpereira.statuspages.model.HealthCheckAttempt.operational;
import static codes.davidpereira.statuspages.model.HealthCheckAttempt.outage;

public class HttpHealthCheckService implements HealthCheckService {

    @Override
    public HealthCheckAttempt doHealthCheck(HealthCheckConfig config) {
        return Try.of(getHttpResponse(config.getUrl(), config.getHeaders(), config.getTimeout()))
                .filter(it -> config.isUp(it.getStatusLine().getStatusCode()))
                .map(it -> operational()).getOrElseGet(it -> outage());
    }

    private CheckedFunction0<HttpResponse> getHttpResponse(String url, Header[] headers, int timeout) {
        return () -> Request.Get(url).connectTimeout(timeout).setHeaders(headers).execute().returnResponse();
    }

}
