package net.sytes.fly.Expenser.service;

import net.sytes.fly.Expenser.dto.Users.SimpleUserResponse;
import net.sytes.fly.Expenser.dto.Users.UserCreate;
import net.sytes.fly.Expenser.dto.Users.UserResponse;
import net.sytes.fly.Expenser.dto.Users.UserUpdate;
import net.sytes.fly.Expenser.entities.User;
import net.sytes.fly.Expenser.exceptions.MonthResultNotFoundException;
import net.sytes.fly.Expenser.exceptions.UserNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface UserService {
    Collection<SimpleUserResponse> findAll();

    @Transactional(rollbackFor = Exception.class)
    UserResponse createUser(UserCreate dto);

    @Transactional(rollbackFor = Exception.class)
    UserResponse updateUser(UserUpdate dto) throws UserNotFoundException, MonthResultNotFoundException;

    @Transactional(rollbackFor = Exception.class)
    void deleteUser(long userId) throws UserNotFoundException;
}
