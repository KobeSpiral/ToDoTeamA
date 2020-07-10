package ja.kobespiral.toDo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ja.kobespiral.toDo.entity.ToDo;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {
    
}