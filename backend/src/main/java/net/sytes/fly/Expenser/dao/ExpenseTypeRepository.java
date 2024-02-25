package net.sytes.fly.Expenser.dao;

import net.sytes.fly.Expenser.entities.ExpenseType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseTypeRepository extends CrudRepository<ExpenseType,Long> {
}
