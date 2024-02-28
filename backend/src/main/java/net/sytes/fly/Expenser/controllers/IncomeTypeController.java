package net.sytes.fly.Expenser.controllers;


import net.sytes.fly.Expenser.dto.IncomeType.IncomeTypeCreate;
import net.sytes.fly.Expenser.dto.IncomeType.IncomeTypeUpdate;
import net.sytes.fly.Expenser.entities.IncomeType;
import net.sytes.fly.Expenser.exceptions.IncomeTypeNotFoundException;
import net.sytes.fly.Expenser.service.IncomeTypeService;
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

    @PostMapping("/create")
    public IncomeType create(@RequestBody IncomeTypeCreate dto){
        return incomeTypeService.createType(dto);
    }

    @PostMapping("/update")
    public IncomeType update(@RequestBody IncomeTypeUpdate dto) throws IncomeTypeNotFoundException {
        return incomeTypeService.updateType(dto);
    }

    @DeleteMapping("/delete/{id}")
    public  void delete(@PathVariable long id) throws IncomeTypeNotFoundException {
        incomeTypeService.deleteType(id);
    }

}
