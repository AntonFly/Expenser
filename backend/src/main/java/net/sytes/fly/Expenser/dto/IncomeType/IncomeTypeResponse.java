package net.sytes.fly.Expenser.dto.IncomeType;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class IncomeTypeResponse {
    @JsonProperty
    long id;
    @JsonProperty
    String name;
    @JsonProperty
    String description;
}
