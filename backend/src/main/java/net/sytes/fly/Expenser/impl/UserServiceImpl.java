package net.sytes.fly.Expenser.impl;

import net.sytes.fly.Expenser.dao.UserRepository;
import net.sytes.fly.Expenser.dto.Users.UserCreate;
import net.sytes.fly.Expenser.dto.Users.UserUpdate;
import net.sytes.fly.Expenser.entities.User;
import net.sytes.fly.Expenser.exceptions.UserNotFoundException;
import net.sytes.fly.Expenser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Collection<User> findAll() {
        return (Collection<User>) userRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User createUser(UserCreate dto) {
        User user = new User();
        user.setName(dto.name());
        user.setSurname(dto.surname());
        user.setPatronymic(dto.patronymic());
        user.setStartSum(dto.startSum());
        return this.userRepository.save(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public User updateUser(UserUpdate dto) throws UserNotFoundException {
        User user = userRepository.findById(dto.id())
                .orElseThrow(()-> new UserNotFoundException("id", String.valueOf(dto.id())));
        user.setName(dto.name());
        user.setSurname(dto.surname());
        user.setPatronymic(dto.patronymic());
        user.setStartSum(dto.startSum());
        return this.userRepository.save(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUser(long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new UserNotFoundException("id", String.valueOf(userId)));
        this.userRepository.delete(user);
    }


}
