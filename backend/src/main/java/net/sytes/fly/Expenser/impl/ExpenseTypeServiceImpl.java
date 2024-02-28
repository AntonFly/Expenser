package net.sytes.fly.Expenser.impl;

import net.sytes.fly.Expenser.dao.ExpenseTypeRepository;
import net.sytes.fly.Expenser.dto.ExpenseType.ExpenseTypeCreate;
import net.sytes.fly.Expenser.dto.ExpenseType.ExpenseTypeUpdate;
import net.sytes.fly.Expenser.entities.ExpenseType;
import net.sytes.fly.Expenser.exceptions.ExpenseTypeNotFoundException;
import net.sytes.fly.Expenser.service.ExpenseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class ExpenseTypeServiceImpl implements ExpenseTypeService {
    private final ExpenseTypeRepository expenseTypeRepository;
    @Autowired
    public ExpenseTypeServiceImpl(ExpenseTypeRepository expenseTypeRepository){
        this.expenseTypeRepository = expenseTypeRepository;
    }

    @Override
    public Collection<ExpenseType> findAll() {
        return (Collection<ExpenseType>) expenseTypeRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ExpenseType createType(ExpenseTypeCreate dto) {
        ExpenseType expenseType = new ExpenseType();
        expenseType.setName(dto.name());
        expenseType.setDescription(dto.description());
        return this.expenseTypeRepository.save(expenseType);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ExpenseType updateType(ExpenseTypeUpdate dto) throws ExpenseTypeNotFoundException {
        ExpenseType expenseType = this.expenseTypeRepository
                .findById(dto.id())
                .orElseThrow(() -> new ExpenseTypeNotFoundException("id",String.valueOf(dto.id())));

        expenseType.setName(dto.name());
        expenseType.setDescription(dto.description());
        return this.expenseTypeRepository.save(expenseType);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteType(long typeId) throws ExpenseTypeNotFoundException {
        ExpenseType expenseType = this.expenseTypeRepository
                .findById(typeId)
                .orElseThrow(() -> new ExpenseTypeNotFoundException("id",String.valueOf(typeId)));
        this.expenseTypeRepository.delete(expenseType);
    }
}
