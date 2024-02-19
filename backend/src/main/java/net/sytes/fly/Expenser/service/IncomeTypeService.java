package net.sytes.fly.Expenser.service;

import net.sytes.fly.Expenser.entities.ExpenseType;
import net.sytes.fly.Expenser.entities.IncomeType;

import java.util.Collection;

public interface IncomeTypeService {
    Collection<IncomeType> findAll();
}
