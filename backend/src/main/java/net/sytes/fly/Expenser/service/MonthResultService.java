package net.sytes.fly.Expenser.service;

import net.sytes.fly.Expenser.dto.MonthResult.MonthResultCreate;
import net.sytes.fly.Expenser.dto.MonthResult.MonthResultUpdate;
import net.sytes.fly.Expenser.dto.Users.UserCreate;
import net.sytes.fly.Expenser.dto.Users.UserUpdate;
import net.sytes.fly.Expenser.entities.MonthResult;
import net.sytes.fly.Expenser.entities.User;
import net.sytes.fly.Expenser.exceptions.MonthResultBadRequestException;
import net.sytes.fly.Expenser.exceptions.MonthResultNotFoundException;
import net.sytes.fly.Expenser.exceptions.UserNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface MonthResultService {
    Collection<MonthResult> findAll();

    @Transactional(rollbackFor = Exception.class)
    MonthResult createMonthResult(MonthResultCreate dto) throws UserNotFoundException, MonthResultBadRequestException;

    @Transactional(rollbackFor = Exception.class)
    MonthResult updateMonthResult(MonthResultUpdate dto) throws MonthResultNotFoundException,MonthResultBadRequestException,UserNotFoundException;

    @Transactional(rollbackFor = Exception.class)
    void deleteMonthResult(long id) throws MonthResultNotFoundException;
}
