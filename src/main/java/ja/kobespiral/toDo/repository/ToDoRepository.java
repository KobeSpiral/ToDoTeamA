package ja.kobespiral.toDo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ja.kobespiral.toDo.entity.ToDo;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {

    // uidからtodoを取得
    public List<ToDo> findTodoByUid(String uid);

}