package net.sytes.fly.Expenser.service;

import net.sytes.fly.Expenser.dto.IncomeType.IncomeTypeCreate;
import net.sytes.fly.Expenser.dto.IncomeType.IncomeTypeEdit;
import net.sytes.fly.Expenser.entities.ExpenseType;
import net.sytes.fly.Expenser.entities.IncomeType;
import net.sytes.fly.Expenser.exceptions.IncomeTypeNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface IncomeTypeService {
    Collection<IncomeType> findAll();

    @Transactional(rollbackFor = Exception.class)
    IncomeType CreateType(IncomeTypeCreate dto);

    @Transactional(rollbackFor = Exception.class)
    IncomeType EditType (IncomeTypeEdit edit) throws IncomeTypeNotFoundException;

    @Transactional(rollbackFor = Exception.class)
    void DeleteType(long typeId) throws IncomeTypeNotFoundException;
}
