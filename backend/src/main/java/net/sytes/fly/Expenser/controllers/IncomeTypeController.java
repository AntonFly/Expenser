package net.sytes.fly.Expenser.controllers;


import net.sytes.fly.Expenser.dto.IncomeType.IncomeTypeCreate;
import net.sytes.fly.Expenser.dto.IncomeType.IncomeTypeEdit;
import net.sytes.fly.Expenser.entities.IncomeType;
import net.sytes.fly.Expenser.entities.Users;
import net.sytes.fly.Expenser.exceptions.IncomeTypeNotFoundException;
import net.sytes.fly.Expenser.service.IncomeTypeService;
import net.sytes.fly.Expenser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController()
@RequestMapping("/incomeType")
public class IncomeTypeController {

    IncomeTypeService incomeTypeService;
    @Autowired
    public IncomeTypeController(IncomeTypeService incomeTypeService) {
        this.incomeTypeService = incomeTypeService;
    }

    @GetMapping("/getAll")
    public Collection<IncomeType> getAll(){
        return incomeTypeService.findAll();
    }

    @PostMapping("/createType")
    public IncomeType create(@RequestBody IncomeTypeCreate dto){
        return incomeTypeService.CreateType(dto);
    }

    @PostMapping("/editType")
    public IncomeType edit(@RequestBody IncomeTypeEdit dto) throws IncomeTypeNotFoundException {
        return incomeTypeService.EditType(dto);
    }

    @DeleteMapping("/deleteType/{id}")
    public  void delete(@PathVariable long id) throws IncomeTypeNotFoundException {
        incomeTypeService.DeleteType(id);
    }

}
