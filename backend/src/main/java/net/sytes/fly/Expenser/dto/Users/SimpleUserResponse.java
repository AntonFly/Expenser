package net.sytes.fly.Expenser.dto.Users;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
public class SimpleUserResponse{
        @JsonProperty("id")
        Long id;
        @JsonProperty("name")
        String name;
        @JsonProperty("patronymic")
        String patronymic;
        @JsonProperty("surname")
        String surname;
        @JsonProperty("startSum")
        BigDecimal startSum;
}
