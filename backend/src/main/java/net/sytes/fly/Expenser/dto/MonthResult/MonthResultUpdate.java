package net.sytes.fly.Expenser.dto.MonthResult;

import java.math.BigDecimal;

public record MonthResultUpdate(
        BigDecimal startSum,
        BigDecimal endSum,
        int month,
        int year,
        long userId,
        long id
) {
}
