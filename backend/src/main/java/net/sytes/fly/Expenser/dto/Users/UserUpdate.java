package net.sytes.fly.Expenser.dto.Users;

import java.math.BigDecimal;

public record UserUpdate(
        Long id,
        String name,
        String patronymic,
        String surname,
        BigDecimal startSum
) {
}
