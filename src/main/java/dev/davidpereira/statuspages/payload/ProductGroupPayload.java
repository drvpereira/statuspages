package dev.davidpereira.statuspages.payload;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ProductGroupPayload {

    private final Long id;

    private final String name;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public ProductGroupPayload(@JsonProperty("id") Long id, @JsonProperty("id") String name) {
        this.id = id;
        this.name = name;
    }

}
