package ja.kobespiral.toDo.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import ja.kobespiral.toDo.entity.ToDo;
import lombok.Data;

@Data
public class CreateToDoForm {
    // ToDo名
    @NotBlank
    @Size(max = 64)
    private String title;

    // 詳細
    @Size(max = 512)
    private String description;

    // 締め切り
    @NotBlank
    private String limitAt;

    public ToDo toEntity(String uid) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        Date d = null;
        try {
            d = df.parse(limitAt);
        } catch (ParseException e) {
        }
        ToDo todo = new ToDo(null, uid, title, description, true, null, d, null, null);
        return todo;
    }
}