package net.sytes.fly.Expenser.dao;

import net.sytes.fly.Expenser.entities.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}
