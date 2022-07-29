package by.theiou.backendtodo.business.repository;

import by.theiou.backendtodo.business.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {
    List<Priority> findByUserEmailOrderByIdAsc(String email);

    @Query("select c from Priority c where (:title is null or :title='' " +
            "or lower(c.title) like lower(concat('%', :title, '%'))) " +
            "and c.user.email=:email order by c.title asc")
    List<Priority> find(@Param("title") String title, @Param("email") String email);
}
