package by.theiou.backendtodo.business.repository;

import by.theiou.backendtodo.business.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByUserEmailOrderByTitleAsc(String email);
}
