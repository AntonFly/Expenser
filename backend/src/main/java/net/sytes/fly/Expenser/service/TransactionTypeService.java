package net.sytes.fly.Expenser.service;

import net.sytes.fly.Expenser.dto.IncomeType.TransactionTypeDTO;
import net.sytes.fly.Expenser.exceptions.TransactionTypeNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface TransactionTypeService {
    Collection<TransactionTypeDTO> findAll();

    @Transactional(rollbackFor = Exception.class)
    TransactionTypeDTO createType(TransactionTypeDTO dto);

    @Transactional(rollbackFor = Exception.class)
    TransactionTypeDTO updateType(TransactionTypeDTO edit) throws TransactionTypeNotFoundException;

    @Transactional(rollbackFor = Exception.class)
    void deleteType(long typeId) throws TransactionTypeNotFoundException;
}
