package to_do.example.to_do.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import to_do.example.to_do.model.entities.ToDo;

import java.util.Optional;

@Repository
public interface ToDoRepository extends  JpaRepository<ToDo, Long> {
    Optional<ToDo> findByCode(Long code);
}
