package net.sytes.fly.Expenser.dao;

import net.sytes.fly.Expenser.entities.TransactionType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionTypeRepository extends CrudRepository<TransactionType, Long> {

}
