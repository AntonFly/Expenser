package net.sytes.fly.Expenser.impl;

import net.sytes.fly.Expenser.dao.UserRepository;
import net.sytes.fly.Expenser.entities.Users;
import net.sytes.fly.Expenser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Collection<Users> findAll() {
        return (Collection<Users>) userRepository.findAll();
    }
}
