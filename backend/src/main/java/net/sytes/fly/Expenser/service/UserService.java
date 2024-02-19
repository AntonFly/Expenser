package net.sytes.fly.Expenser.service;

import net.sytes.fly.Expenser.entities.Users;

import java.util.Collection;

public interface UserService {
    Collection<Users> findAll();
}
