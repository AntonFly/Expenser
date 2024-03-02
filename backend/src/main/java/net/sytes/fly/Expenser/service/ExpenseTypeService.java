package net.sytes.fly.Expenser.service;

import net.sytes.fly.Expenser.dto.ExpenseType.ExpenseTypeCreate;
import net.sytes.fly.Expenser.dto.ExpenseType.ExpenseTypeResponse;
import net.sytes.fly.Expenser.dto.ExpenseType.ExpenseTypeUpdate;
import net.sytes.fly.Expenser.entities.ExpenseType;
import net.sytes.fly.Expenser.exceptions.ExpenseTypeNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface ExpenseTypeService {


    Collection<ExpenseTypeResponse> findAll();

    @Transactional(rollbackFor = Exception.class)
    ExpenseTypeResponse createType(ExpenseTypeCreate dto);

    @Transactional(rollbackFor = Exception.class)
    ExpenseTypeResponse updateType(ExpenseTypeUpdate edit) throws ExpenseTypeNotFoundException;

    @Transactional(rollbackFor = Exception.class)
    void deleteType(long typeId) throws ExpenseTypeNotFoundException;

}
