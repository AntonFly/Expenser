package net.sytes.fly.Expenser.service;

import net.sytes.fly.Expenser.dto.Income.TransactionDTO;
import net.sytes.fly.Expenser.dto.Users.SimpleUserResponse;
import net.sytes.fly.Expenser.dto.Users.UserCreate;
import net.sytes.fly.Expenser.dto.Users.UserResponse;
import net.sytes.fly.Expenser.dto.Users.UserUpdate;
import net.sytes.fly.Expenser.exceptions.MonthResultNotFoundException;
import net.sytes.fly.Expenser.exceptions.TransactionNotFoundException;
import net.sytes.fly.Expenser.exceptions.TransactionTypeNotFoundException;
import net.sytes.fly.Expenser.exceptions.UserNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface TransactionService {
    Collection<TransactionDTO> findAll();

    @Transactional(rollbackFor = Exception.class)
    TransactionDTO createTransaction(TransactionDTO dto) throws UserNotFoundException, TransactionNotFoundException, TransactionTypeNotFoundException;

    @Transactional(rollbackFor = Exception.class)
    TransactionDTO updateTransaction(TransactionDTO dto) throws UserNotFoundException, TransactionNotFoundException, TransactionNotFoundException, TransactionTypeNotFoundException;

    @Transactional(rollbackFor = Exception.class)
    void deleteTransaction(long transactionId);
}
