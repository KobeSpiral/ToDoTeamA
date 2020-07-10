package ja.kobespiral.toDo.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import ja.kobespiral.toDo.entity.User;
import lombok.Data;

@Data
public class UserForm {

    // ユーザID max16文字で英数字
    @Size(max = 16)
    @Pattern(regexp = "[0-9a-zA-Z_\\-]+")
    @NotBlank
    private String uid;

    // ユーザ名 空白以外
    @NotBlank
    private String name;

    public User toEntity() {
        return new User(null, uid, name, new Date());
    }
}