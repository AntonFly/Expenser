package net.sytes.fly.Expenser.dto.Income;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class TransactionDTO {
    @JsonProperty
    Long id;
    @JsonProperty
    BigDecimal sum;
    @JsonProperty
    String date;
    @JsonProperty
    String comment;
    @JsonProperty
    long typeId;
    @JsonProperty
    long userId;
}
