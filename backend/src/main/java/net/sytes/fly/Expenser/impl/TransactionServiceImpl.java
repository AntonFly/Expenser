package net.sytes.fly.Expenser.impl;

import net.sytes.fly.Expenser.dao.TransactionRepository;
import net.sytes.fly.Expenser.dao.TransactionTypeRepository;
import net.sytes.fly.Expenser.dao.UserRepository;
import net.sytes.fly.Expenser.dto.Income.TransactionDTO;
import net.sytes.fly.Expenser.entities.Transaction;
import net.sytes.fly.Expenser.exceptions.TransactionNotFoundException;
import net.sytes.fly.Expenser.exceptions.TransactionTypeNotFoundException;
import net.sytes.fly.Expenser.exceptions.UserNotFoundException;
import net.sytes.fly.Expenser.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final TransactionTypeRepository transactionTypeRepository;


    @Autowired
    public TransactionServiceImpl(
            TransactionRepository transactionRepository,
            UserRepository userRepository,
            TransactionTypeRepository transactionTypeRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
        this.transactionTypeRepository = transactionTypeRepository;
    }

    @Override
    public Collection<TransactionDTO> findAll() {
        return ((Collection<Transaction>) transactionRepository.findAll()).stream()
                .map(Transaction::toResponse).toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TransactionDTO createTransaction(TransactionDTO dto) throws UserNotFoundException, TransactionTypeNotFoundException {
        return transactionRepository.save(toModel(dto)).toResponse();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TransactionDTO updateTransaction(TransactionDTO dto) throws UserNotFoundException, TransactionNotFoundException, TransactionTypeNotFoundException {
        if(transactionRepository.findById(dto.getId()).isEmpty())
                throw new TransactionNotFoundException("id", String.valueOf(dto.getId()));
        Transaction transaction = toModel(dto);
        return transactionRepository.save(transaction).toResponse();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTransaction(long transactionId) {

    }

    public Transaction toModel(TransactionDTO dto) throws TransactionTypeNotFoundException, UserNotFoundException {
        Transaction transaction = new Transaction();

        if(dto.getId() != null)
            transaction.setId(dto.getId());

        transaction.setSum(dto.getSum());
        transaction.setDate(LocalDate.parse(dto.getDate(),DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        transaction.setComment(dto.getComment());

        transaction.setTransactionType(transactionTypeRepository.findById(dto.getTypeId())
                .orElseThrow(()-> new TransactionTypeNotFoundException("id", String.valueOf(dto.getTypeId()))));

        transaction.setUser(userRepository.findById(dto.getUserId())
                .orElseThrow(()-> new UserNotFoundException("id", String.valueOf(dto.getUserId()))));

        return transaction;
    }
}
