package net.sytes.fly.Expenser.dto.MonthResult;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import net.sytes.fly.Expenser.entities.MonthResult;

import java.math.BigDecimal;

@AllArgsConstructor
public class MonthResultResponse {
    @JsonProperty
    BigDecimal startSum;
    @JsonProperty
    BigDecimal endSum;
    @JsonProperty
    int month;
    @JsonProperty
    int year;
    @JsonProperty
    long userId;
    @JsonProperty
    long id;



}
