package ja.kobespiral.toDo.dto;

import java.util.Date;

import ja.kobespiral.toDo.entity.ToDo;
import lombok.Data;

@Data
public class ToDoDto {
    private Long tid;
    private String uid;
    private String title;
    private String description;
    private boolean isOpen;
    private Date createdAt;
    private Date limitAt;
    private Date doneAt;

    /**
     * ToDoEntityからDTOを作成
     * 
     */
    public static ToDoDto build(ToDo todo) {
        ToDoDto dto = new ToDoDto();
        dto.tid = todo.getId();
        dto.uid = todo.getUid();
        dto.title = todo.getTitle();
        dto.description = todo.getDescription();
        dto.isOpen = todo.isOpen();
        dto.createdAt = todo.getCreatedAt();
        dto.limitAt = todo.getLimitAt();
        dto.doneAt = todo.getDoneAt();
        return dto;
    }
}