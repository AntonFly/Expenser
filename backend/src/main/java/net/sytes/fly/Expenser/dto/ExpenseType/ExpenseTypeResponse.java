package net.sytes.fly.Expenser.dto.ExpenseType;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ExpenseTypeResponse {
    @JsonProperty
    long id;
    @JsonProperty
    String name;
    @JsonProperty
    String description;
}
