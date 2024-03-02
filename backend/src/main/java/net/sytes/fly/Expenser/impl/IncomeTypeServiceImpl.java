package net.sytes.fly.Expenser.impl;

import net.sytes.fly.Expenser.dao.IncomeTypeRepository;
import net.sytes.fly.Expenser.dto.IncomeType.IncomeTypeCreate;
import net.sytes.fly.Expenser.dto.IncomeType.IncomeTypeResponse;
import net.sytes.fly.Expenser.dto.IncomeType.IncomeTypeUpdate;
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
    public Collection<IncomeTypeResponse> findAll() {
        return ((Collection<IncomeType>) incomeTypeRepository.findAll()).stream()
                .map(IncomeType::toResponse).toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public IncomeTypeResponse createType(IncomeTypeCreate dto) {
        IncomeType incomeType = new IncomeType();
        incomeType.setName(dto.name());
        incomeType.setDescription(dto.description());
        return this.incomeTypeRepository.save(incomeType).toResponse();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public IncomeTypeResponse updateType(IncomeTypeUpdate dto) throws IncomeTypeNotFoundException {
        IncomeType incomeType = this.incomeTypeRepository
                .findById(dto.id())
                .orElseThrow(() -> new IncomeTypeNotFoundException("id",String.valueOf(dto.id())));

        incomeType.setName(dto.name());
        incomeType.setDescription(dto.description());
        return this.incomeTypeRepository.save(incomeType).toResponse();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteType(long typeId) throws IncomeTypeNotFoundException {
        IncomeType incomeType = this.incomeTypeRepository
                .findById(typeId)
                .orElseThrow(() -> new IncomeTypeNotFoundException("id",String.valueOf(typeId)));
        this.incomeTypeRepository.delete(incomeType);
    }
}
