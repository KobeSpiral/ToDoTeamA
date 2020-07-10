package ja.kobespiral.toDo.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import ja.kobespiral.toDo.entity.User;
import lombok.Data;

@Data
public class UserForm {
    
    @Pattern(regexp = "[0-9]+")
    private String uid;

    @NotBlank
    private String name;

    public User toEntity(){
        return new User(Long.parseLong(uid), name, new Date());
    }
}