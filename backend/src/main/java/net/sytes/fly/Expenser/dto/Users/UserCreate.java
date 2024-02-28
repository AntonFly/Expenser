package net.sytes.fly.Expenser.dto.Users;

import java.math.BigDecimal;

public record UserCreate(
        String name,
        String patronymic,
        String surname,
        BigDecimal startSum
) {
}
