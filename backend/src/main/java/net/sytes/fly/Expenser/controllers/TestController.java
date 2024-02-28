package net.sytes.fly.Expenser.controllers;

import net.sytes.fly.Expenser.entities.User;
import net.sytes.fly.Expenser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class TestController {

    UserService incomeTypeService;
    @Autowired
    public TestController(UserService incomeTypeService) {
        this.incomeTypeService = incomeTypeService;
    }

    @GetMapping("/test")
    public Collection<User> test(){
        return incomeTypeService.findAll();
    }
}
