package net.sytes.fly.Expenser.service;

import net.sytes.fly.Expenser.dto.IncomeType.IncomeTypeCreate;
import net.sytes.fly.Expenser.dto.IncomeType.IncomeTypeResponse;
import net.sytes.fly.Expenser.dto.IncomeType.IncomeTypeUpdate;
import net.sytes.fly.Expenser.entities.IncomeType;
import net.sytes.fly.Expenser.exceptions.IncomeTypeNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface IncomeTypeService {
    Collection<IncomeTypeResponse> findAll();

    @Transactional(rollbackFor = Exception.class)
    IncomeTypeResponse createType(IncomeTypeCreate dto);

    @Transactional(rollbackFor = Exception.class)
    IncomeTypeResponse updateType(IncomeTypeUpdate edit) throws IncomeTypeNotFoundException;

    @Transactional(rollbackFor = Exception.class)
    void deleteType(long typeId) throws IncomeTypeNotFoundException;
}
