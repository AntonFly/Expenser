package net.sytes.fly.Expenser.dao;

import net.sytes.fly.Expenser.entities.MonthResult;
import net.sytes.fly.Expenser.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface MonthResultRepository extends CrudRepository<MonthResult, Long> {

    Optional<MonthResult> findFirstByUser_IdUserAndStartSumOrderByYearAscMonthAsc(@NonNull long idUser, @NonNull BigDecimal startSum);

}
