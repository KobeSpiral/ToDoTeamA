package ja.kobespiral.toDo.form;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SearchForm {
    // ユーザID max16文字で英数字
    @Size(max = 16)
    @Pattern(regexp = "[0-9a-zA-Z_\\-]*")
    private String uid;

    private String name;

}