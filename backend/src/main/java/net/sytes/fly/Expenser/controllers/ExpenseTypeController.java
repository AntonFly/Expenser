package net.sytes.fly.Expenser.controllers;


import net.sytes.fly.Expenser.dto.ExpenseType.ExpenseTypeCreate;
import net.sytes.fly.Expenser.dto.ExpenseType.ExpenseTypeResponse;
import net.sytes.fly.Expenser.dto.ExpenseType.ExpenseTypeUpdate;
import net.sytes.fly.Expenser.entities.ExpenseType;
import net.sytes.fly.Expenser.exceptions.ExpenseTypeNotFoundException;
import net.sytes.fly.Expenser.service.ExpenseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController()
@RequestMapping("/expenseType")
public class ExpenseTypeController {

    ExpenseTypeService expenseTypeService;
    @Autowired
    public ExpenseTypeController(ExpenseTypeService expenseTypeService) {
        this.expenseTypeService = expenseTypeService;
    }

    @GetMapping("/getAll")
    public Collection<ExpenseTypeResponse> getAll(){
        return expenseTypeService.findAll();
    }

    @PostMapping("/create")
    public ExpenseTypeResponse create(@RequestBody ExpenseTypeCreate dto){
        return expenseTypeService.createType(dto);
    }

    @PostMapping("/update")
    public ExpenseTypeResponse update(@RequestBody ExpenseTypeUpdate dto) throws ExpenseTypeNotFoundException {
        return expenseTypeService.updateType(dto);
    }

    @DeleteMapping("/delete/{id}")
    public  void delete(@PathVariable long id) throws ExpenseTypeNotFoundException {
        expenseTypeService.deleteType(id);
    }

}
