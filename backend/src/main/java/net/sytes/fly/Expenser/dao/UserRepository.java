package net.sytes.fly.Expenser.dao;

import net.sytes.fly.Expenser.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
