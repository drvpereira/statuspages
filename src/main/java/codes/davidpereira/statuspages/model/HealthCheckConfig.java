package codes.davidpereira.statuspages.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.util.Map;
import java.util.Set;

import static java.util.Optional.ofNullable;

@Builder @Getter
public class HealthCheckConfig {

    @NonNull
    private HealthCheckType type;

    @NonNull
    private String url;

    private String method;

    private Map<String, String> headers;

    private int upStatus;

    private int timeout;

    public boolean isUp(int statusCode) {
        return upStatus == statusCode;
    }

    public Header[] getHeaders() {
        return ofNullable(headers).map(Map::entrySet).stream().flatMap(Set::stream).
                map(it -> new BasicHeader(it.getKey(), it.getValue())).toArray(Header[]::new);
    }

}
