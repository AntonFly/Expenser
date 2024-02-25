package net.sytes.fly.Expenser.controllers;


import net.sytes.fly.Expenser.dto.ExpenseType.ExpenseTypeCreate;
import net.sytes.fly.Expenser.dto.ExpenseType.ExpenseTypeEdit;
import net.sytes.fly.Expenser.dto.IncomeType.IncomeTypeCreate;
import net.sytes.fly.Expenser.dto.IncomeType.IncomeTypeEdit;
import net.sytes.fly.Expenser.entities.ExpenseType;
import net.sytes.fly.Expenser.entities.IncomeType;
import net.sytes.fly.Expenser.exceptions.ExpenseTypeNotFoundException;
import net.sytes.fly.Expenser.exceptions.IncomeTypeNotFoundException;
import net.sytes.fly.Expenser.service.ExpenseTypeService;
import net.sytes.fly.Expenser.service.IncomeTypeService;
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
    public Collection<ExpenseType> getAll(){
        return expenseTypeService.findAll();
    }

    @PostMapping("/createType")
    public ExpenseType create(@RequestBody ExpenseTypeCreate dto){
        return expenseTypeService.CreateType(dto);
    }

    @PostMapping("/editType")
    public ExpenseType edit(@RequestBody ExpenseTypeEdit dto) throws ExpenseTypeNotFoundException {
        return expenseTypeService.EditType(dto);
    }

    @DeleteMapping("/deleteType/{id}")
    public  void delete(@PathVariable long id) throws ExpenseTypeNotFoundException {
        expenseTypeService.DeleteType(id);
    }

}
