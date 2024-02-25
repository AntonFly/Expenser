package net.sytes.fly.Expenser.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import net.sytes.fly.Expenser.dao.IncomeTypeRepository;
import net.sytes.fly.Expenser.dto.IncomeType.IncomeTypeCreate;
import net.sytes.fly.Expenser.dto.IncomeType.IncomeTypeEdit;
import net.sytes.fly.Expenser.entities.ExpenseType;
import net.sytes.fly.Expenser.entities.IncomeType;
import net.sytes.fly.Expenser.exceptions.IncomeTypeNotFoundException;
import net.sytes.fly.Expenser.service.IncomeTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public IncomeType CreateType(IncomeTypeCreate dto) {
        IncomeType incomeType = new IncomeType();
        incomeType.setName(dto.name());
        incomeType.setDescription(dto.description());
        return this.incomeTypeRepository.save(incomeType);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public IncomeType EditType(IncomeTypeEdit dto) throws IncomeTypeNotFoundException {
        IncomeType incomeType = this.incomeTypeRepository
                .findById(dto.id())
                .orElseThrow(() -> new IncomeTypeNotFoundException("id",String.valueOf(dto.id())));

        incomeType.setName(dto.name());
        incomeType.setDescription(dto.description());
        return this.incomeTypeRepository.save(incomeType);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void DeleteType(long typeId) throws IncomeTypeNotFoundException {
        IncomeType incomeType = this.incomeTypeRepository
                .findById(typeId)
                .orElseThrow(() -> new IncomeTypeNotFoundException("id",String.valueOf(typeId)));
        this.incomeTypeRepository.delete(incomeType);
    }
}
