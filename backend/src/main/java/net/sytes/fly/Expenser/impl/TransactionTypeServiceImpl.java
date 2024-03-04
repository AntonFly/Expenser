package net.sytes.fly.Expenser.impl;

import net.sytes.fly.Expenser.dao.TransactionTypeRepository;
import net.sytes.fly.Expenser.dto.IncomeType.TransactionTypeDTO;
import net.sytes.fly.Expenser.entities.TransactionType;
import net.sytes.fly.Expenser.exceptions.TransactionTypeNotFoundException;
import net.sytes.fly.Expenser.service.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Service
public class TransactionTypeServiceImpl implements TransactionTypeService {
    private final TransactionTypeRepository transactionTypeRepository;
    @Autowired
    public TransactionTypeServiceImpl(TransactionTypeRepository transactionTypeRepository){
        this.transactionTypeRepository = transactionTypeRepository;
    }

    @Override
    public Collection<TransactionTypeDTO> findAll() {
        return ((Collection<TransactionType>) transactionTypeRepository.findAll()).stream()
                .map(TransactionType::toResponse).toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TransactionTypeDTO createType(TransactionTypeDTO dto) {
        TransactionType transactionType = new TransactionType();
        transactionType.setName(dto.getName());
        transactionType.setDescription(dto.getDescription());
        transactionType.setIncome(dto.isIncome());
        return this.transactionTypeRepository.save(transactionType).toResponse();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TransactionTypeDTO updateType(TransactionTypeDTO dto) throws TransactionTypeNotFoundException {
        TransactionType transactionType = this.transactionTypeRepository
                .findById(dto.getId())
                .orElseThrow(() -> new TransactionTypeNotFoundException("id",String.valueOf(dto.getId())));

        transactionType.setName(dto.getName());
        transactionType.setDescription(dto.getDescription());
        return this.transactionTypeRepository.save(transactionType).toResponse();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteType(long typeId) throws TransactionTypeNotFoundException {
        TransactionType transactionType = this.transactionTypeRepository
                .findById(typeId)
                .orElseThrow(() -> new TransactionTypeNotFoundException("id",String.valueOf(typeId)));
        this.transactionTypeRepository.delete(transactionType);
    }
}
