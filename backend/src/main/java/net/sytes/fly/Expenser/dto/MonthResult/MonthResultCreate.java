package net.sytes.fly.Expenser.dto.MonthResult;

import java.math.BigDecimal;

public record MonthResultCreate(
        BigDecimal startSum,
        BigDecimal endSum,
        int month,
        int year,
        long userId
) {
}
