package net.sytes.fly.Expenser.impl;

import net.sytes.fly.Expenser.dao.IncomeTypeRepository;
import net.sytes.fly.Expenser.entities.ExpenseType;
import net.sytes.fly.Expenser.entities.IncomeType;
import net.sytes.fly.Expenser.service.IncomeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class IncomeTypeServiceImpl implements IncomeTypeService {
    private final IncomeTypeRepository incomeTypeRepository;
    @Autowired
    public IncomeTypeServiceImpl(IncomeTypeRepository incomeTypeRepository){
        this.incomeTypeRepository = incomeTypeRepository;
    }

    @Override
    public Collection<IncomeType> findAll() {
        return (Collection<IncomeType>) incomeTypeRepository.findAll();
    }
}
