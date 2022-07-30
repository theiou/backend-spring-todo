package by.theiou.backendtodo.business.repository;

import by.theiou.backendtodo.business.entity.Stat;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatRepository extends CrudRepository<Stat, Long> {
    Stat findByUserEmail(String email);
}
