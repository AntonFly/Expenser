package net.sytes.fly.Expenser.impl;

import net.sytes.fly.Expenser.dao.MonthResultRepository;
import net.sytes.fly.Expenser.dao.UserRepository;
import net.sytes.fly.Expenser.dto.MonthResult.MonthResultResponse;
import net.sytes.fly.Expenser.dto.Users.SimpleUserResponse;
import net.sytes.fly.Expenser.dto.Users.UserCreate;
import net.sytes.fly.Expenser.dto.Users.UserResponse;
import net.sytes.fly.Expenser.dto.Users.UserUpdate;
import net.sytes.fly.Expenser.entities.MonthResult;
import net.sytes.fly.Expenser.entities.User;
import net.sytes.fly.Expenser.exceptions.MonthResultNotFoundException;
import net.sytes.fly.Expenser.exceptions.UserNotFoundException;
import net.sytes.fly.Expenser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final MonthResultRepository monthResultRepository;
    @Autowired
    public UserServiceImpl(
            UserRepository userRepository,
            MonthResultRepository monthResultRepository
    ){
        this.userRepository = userRepository;
        this.monthResultRepository = monthResultRepository;
    }

    @Override
    public Collection<SimpleUserResponse> findAll() {
        return ((Collection<User>) userRepository.findAll()).stream()
                .map(User::toSimpleResponse).toList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserResponse createUser(UserCreate dto) {
        User user = new User();
        user.setName(dto.name());
        user.setSurname(dto.surname());
        user.setPatronymic(dto.patronymic());
        user.setStartSum(dto.startSum());


        MonthResult mr = new MonthResult();
        mr.setUser(user);
        mr.setMonth(LocalDate.now().getMonthValue());
        mr.setYear(LocalDate.now().getYear());
        mr.setStartSum(dto.startSum());
        mr.setEndSum(dto.startSum());

        user =  this.userRepository.save(user);
        this.monthResultRepository.save(mr);

        user.setMonthResultList(List.of(mr));
        return user.toResponse();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserResponse updateUser(UserUpdate dto) throws UserNotFoundException, MonthResultNotFoundException {
        User user = userRepository.findById(dto.id())
                .orElseThrow(()-> new UserNotFoundException("id", String.valueOf(dto.id())));
        user.setName(dto.name());
        user.setSurname(dto.surname());
        user.setPatronymic(dto.patronymic());

        if(!user.getStartSum().equals(dto.startSum())){
            MonthResult firstMR = this.monthResultRepository.findFirstByUser_IdUserAndStartSumOrderByYearAscMonthAsc(
                    user.getIdUser(),user.getStartSum()).orElseThrow(()->
                    new MonthResultNotFoundException("первого месяца для пользователя id", String.valueOf(dto.id())));
            firstMR.setStartSum(dto.startSum());
            //TODO: calculate month end sum according new user start sum
            user.setStartSum(dto.startSum());
        }
        user = this.userRepository.save(user);
        return user.toResponse();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("id", String.valueOf(userId)));
        this.monthResultRepository.deleteAll(user.getMonthResultList());
        this.userRepository.delete(user);
    }



}
