package net.sytes.fly.Expenser.service;

import net.sytes.fly.Expenser.dto.ExpenseType.ExpenseTypeCreate;
import net.sytes.fly.Expenser.dto.ExpenseType.ExpenseTypeEdit;
import net.sytes.fly.Expenser.dto.IncomeType.IncomeTypeCreate;
import net.sytes.fly.Expenser.dto.IncomeType.IncomeTypeEdit;
import net.sytes.fly.Expenser.entities.ExpenseType;
import net.sytes.fly.Expenser.entities.IncomeType;
import net.sytes.fly.Expenser.exceptions.ExpenseTypeNotFoundException;
import net.sytes.fly.Expenser.exceptions.IncomeTypeNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface ExpenseTypeService {


    Collection<ExpenseType> findAll();

    @Transactional(rollbackFor = Exception.class)
    ExpenseType CreateType(ExpenseTypeCreate dto);

    @Transactional(rollbackFor = Exception.class)
    ExpenseType EditType (ExpenseTypeEdit edit) throws ExpenseTypeNotFoundException;

    @Transactional(rollbackFor = Exception.class)
    void DeleteType(long typeId) throws ExpenseTypeNotFoundException;

}
