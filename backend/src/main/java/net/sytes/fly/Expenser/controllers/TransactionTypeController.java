package net.sytes.fly.Expenser.controllers;


import net.sytes.fly.Expenser.dto.IncomeType.TransactionTypeDTO;
import net.sytes.fly.Expenser.exceptions.TransactionTypeNotFoundException;
import net.sytes.fly.Expenser.service.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController()
@RequestMapping("/transactionType")
public class TransactionTypeController {

    TransactionTypeService transactionTypeService;
    @Autowired
    public TransactionTypeController(TransactionTypeService transactionTypeService) {
        this.transactionTypeService = transactionTypeService;
    }

    @GetMapping("/getAll")
    public Collection<TransactionTypeDTO> getAll(){
        return transactionTypeService.findAll();
    }

    @PostMapping("/create")
    public TransactionTypeDTO create(@RequestBody TransactionTypeDTO dto){
        return transactionTypeService.createType(dto);
    }

    @PostMapping("/update")
    public TransactionTypeDTO update(@RequestBody TransactionTypeDTO dto) throws TransactionTypeNotFoundException {
        return transactionTypeService.updateType(dto);
    }

    @DeleteMapping("/delete/{id}")
    public  void delete(@PathVariable long id) throws TransactionTypeNotFoundException {
        transactionTypeService.deleteType(id);
    }

}
