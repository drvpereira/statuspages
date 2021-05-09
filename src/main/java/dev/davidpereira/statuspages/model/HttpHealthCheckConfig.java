package dev.davidpereira.statuspages.model;

import io.vavr.CheckedFunction0;
import io.vavr.control.Try;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicHeader;

import java.util.Map;
import java.util.Set;

import static dev.davidpereira.statuspages.model.HealthCheckAttempt.operational;
import static dev.davidpereira.statuspages.model.HealthCheckAttempt.outage;
import static java.util.Optional.ofNullable;

@Builder @Getter
public class HttpHealthCheckConfig extends HealthCheckConfig {

    @NonNull
    private String url;

    private String method;

    private Map<String, String> headers;

    private String requestBody;

    private int upStatus;

    private int timeout;

    @Override
    public HealthCheckAttempt doHealthCheck() {
        return Try.of(getHttpResponse())
                .filter(it -> isUp(it.getStatusLine().getStatusCode()))
                .map(it -> operational()).getOrElseGet(it -> outage());
    }

    private boolean isUp(int statusCode) {
        return upStatus == statusCode;
    }

    private CheckedFunction0<HttpResponse> getHttpResponse() {
        var headers = ofNullable(this.headers).map(Map::entrySet).stream().flatMap(Set::stream).
                map(it -> new BasicHeader(it.getKey(), it.getValue())).toArray(Header[]::new);
        return () -> Request.Get(url).connectTimeout(timeout).setHeaders(headers).execute().returnResponse();
    }

}
