package dev.davidpereira.statuspages.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ProductPayload {

    private final Long id;

    private final String name;

    private final String status;

    private final ProductGroupPayload group;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ProductPayload(@JsonProperty("id") Long id, @JsonProperty("id") String name,
                          @JsonProperty("status") String status, @JsonProperty("group") ProductGroupPayload group) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.group = group;
    }

}
