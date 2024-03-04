package net.sytes.fly.Expenser.dto.IncomeType;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class TransactionTypeDTO {
    @JsonProperty
    long id;
    @JsonProperty
    String name;
    @JsonProperty
    String description;
    @JsonProperty
    boolean isIncome;
}
