package net.sytes.fly.Expenser.controllers;


import net.sytes.fly.Expenser.dto.MonthResult.MonthResultCreate;
import net.sytes.fly.Expenser.dto.MonthResult.MonthResultUpdate;
import net.sytes.fly.Expenser.dto.Users.UserCreate;
import net.sytes.fly.Expenser.dto.Users.UserUpdate;
import net.sytes.fly.Expenser.entities.MonthResult;
import net.sytes.fly.Expenser.entities.User;
import net.sytes.fly.Expenser.exceptions.MonthResultBadRequestException;
import net.sytes.fly.Expenser.exceptions.MonthResultNotFoundException;
import net.sytes.fly.Expenser.exceptions.UserNotFoundException;
import net.sytes.fly.Expenser.service.MonthResultService;
import net.sytes.fly.Expenser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController()
@RequestMapping("/monthResult")
public class MonthResultController {

    MonthResultService monthResultService;
    @Autowired
    public MonthResultController(MonthResultService monthResultService) {
        this.monthResultService = monthResultService;
    }

    @GetMapping("/getAll")
    public Collection<MonthResult> getAll(){
        return monthResultService.findAll();
    }

    @PostMapping("/create")
    public MonthResult create(@RequestBody MonthResultCreate dto) throws UserNotFoundException, MonthResultBadRequestException {
        return monthResultService.createMonthResult(dto);
    }

    @PostMapping("/update")
    public MonthResult edit(@RequestBody MonthResultUpdate dto) throws UserNotFoundException, MonthResultNotFoundException, MonthResultBadRequestException {
        return monthResultService.updateMonthResult(dto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) throws MonthResultNotFoundException {
        monthResultService.deleteMonthResult(id);
    }

}
