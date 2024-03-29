package net.sytes.fly.Expenser.controllers;


import net.sytes.fly.Expenser.dto.Users.SimpleUserResponse;
import net.sytes.fly.Expenser.dto.Users.UserCreate;
import net.sytes.fly.Expenser.dto.Users.UserResponse;
import net.sytes.fly.Expenser.dto.Users.UserUpdate;
import net.sytes.fly.Expenser.entities.User;
import net.sytes.fly.Expenser.exceptions.MonthResultNotFoundException;
import net.sytes.fly.Expenser.exceptions.UserNotFoundException;
import net.sytes.fly.Expenser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController()
@RequestMapping("/users")
public class UserController {

    UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public Collection<SimpleUserResponse> getAll(){
        return userService.findAll();
    }

    @PostMapping("/create")
    public UserResponse create(@RequestBody UserCreate dto){
        return userService.createUser(dto);
    }

    @PostMapping("/update")
    public UserResponse update(@RequestBody UserUpdate dto) throws UserNotFoundException, MonthResultNotFoundException {
        return userService.updateUser(dto);
    }

    @DeleteMapping("/delete/{id}")
    public  void delete(@PathVariable long id) throws UserNotFoundException {
        userService.deleteUser(id);
    }

}
