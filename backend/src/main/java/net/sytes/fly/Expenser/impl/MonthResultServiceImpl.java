package net.sytes.fly.Expenser.impl;

import net.sytes.fly.Expenser.dao.MonthResultRepository;
import net.sytes.fly.Expenser.dao.UserRepository;
import net.sytes.fly.Expenser.dto.MonthResult.MonthResultCreate;
import net.sytes.fly.Expenser.dto.MonthResult.MonthResultResponse;
import net.sytes.fly.Expenser.dto.MonthResult.MonthResultUpdate;
import net.sytes.fly.Expenser.dto.Users.UserCreate;
import net.sytes.fly.Expenser.dto.Users.UserUpdate;
import net.sytes.fly.Expenser.entities.MonthResult;
import net.sytes.fly.Expenser.entities.User;
import net.sytes.fly.Expenser.exceptions.MonthResultBadRequestException;
import net.sytes.fly.Expenser.exceptions.MonthResultNotFoundException;
import net.sytes.fly.Expenser.exceptions.UserNotFoundException;
import net.sytes.fly.Expenser.service.MonthResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.Collection;
@Service
public class MonthResultServiceImpl implements MonthResultService {

    private final MonthResultRepository monthResultRepository;
    private final UserRepository userRepository;

    @Autowired
    public MonthResultServiceImpl(
            MonthResultRepository monthResultRepository,
            UserRepository userRepository) {
        this.monthResultRepository = monthResultRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Collection<MonthResultResponse> findAll() {
        return ((Collection<MonthResult>) monthResultRepository.findAll()).stream()
                .map(MonthResult::toResponse).toList();
    }

    @Override
    public MonthResultResponse createMonthResult(MonthResultCreate dto) throws UserNotFoundException,MonthResultBadRequestException {
        if(dto.month() > 12)
            throw new MonthResultBadRequestException("месяц", String.valueOf(dto.month()));
        if(dto.year() < 0 )
            throw new MonthResultBadRequestException("год", String.valueOf(dto.year()));

        User user = this.userRepository.findById(dto.userId())
                .orElseThrow(() -> new UserNotFoundException("id", String.valueOf(dto.userId())));

        MonthResult mr = new MonthResult();
        mr.setStartSum(dto.startSum());
        mr.setEndSum(dto.endSum());
        mr.setYear(dto.year());
        mr.setMonth(dto.month());
        mr.setUser(user);

        return monthResultRepository.save(mr).toResponse();
    }

    @Override
    public MonthResultResponse updateMonthResult(MonthResultUpdate dto) throws MonthResultNotFoundException, MonthResultBadRequestException, UserNotFoundException {
        if(dto.month() > 12)
            throw new MonthResultBadRequestException("месяц", String.valueOf(dto.month()));
        if(dto.year() < 0 )
            throw new MonthResultBadRequestException("год", String.valueOf(dto.year()));


        MonthResult mr = this.monthResultRepository.findById(dto.id())
                .orElseThrow(()-> new MonthResultNotFoundException("id", String.valueOf(dto.id())));

        User user = this.userRepository.findById(dto.userId())
                .orElseThrow(() -> new UserNotFoundException("id", String.valueOf(dto.userId())));

        mr.setStartSum(dto.startSum());
        mr.setEndSum(dto.endSum());
        mr.setYear(dto.year());
        mr.setMonth(dto.month());
        mr.setUser(user);

        return monthResultRepository.save(mr).toResponse();
    }

    @Override
    public void deleteMonthResult(long id) throws MonthResultNotFoundException {
        MonthResult mr = this.monthResultRepository.findById(id)
                .orElseThrow(()-> new MonthResultNotFoundException("id", String.valueOf(id)));

        this.monthResultRepository.delete(mr);
    }


}
