package net.sytes.fly.Expenser.dao;

import net.sytes.fly.Expenser.entities.Income;
import net.sytes.fly.Expenser.entities.IncomeType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncomeTypeRepository extends CrudRepository<IncomeType, Long> {

}
