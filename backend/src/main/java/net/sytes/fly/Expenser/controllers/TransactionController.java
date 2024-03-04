package net.sytes.fly.Expenser.controllers;

import net.sytes.fly.Expenser.dto.Income.TransactionDTO;
import net.sytes.fly.Expenser.exceptions.TransactionNotFoundException;
import net.sytes.fly.Expenser.exceptions.TransactionTypeNotFoundException;
import net.sytes.fly.Expenser.exceptions.UserNotFoundException;
import net.sytes.fly.Expenser.service.TransactionService;
import net.sytes.fly.Expenser.service.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController()
@RequestMapping("/transaction")
public class TransactionController {
    TransactionService transactionService;
    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/getAll")
    public Collection<TransactionDTO> getAll(){
        return transactionService.findAll();
    }

    @PostMapping("/create")
    public TransactionDTO create(@RequestBody TransactionDTO dto) throws UserNotFoundException, TransactionTypeNotFoundException, TransactionNotFoundException {
        return transactionService.createTransaction(dto);
    }
}
