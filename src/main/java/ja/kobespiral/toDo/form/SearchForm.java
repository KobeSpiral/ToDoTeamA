package ja.kobespiral.toDo.form;

import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class SearchForm {
    @Pattern(regexp = "[0-9]+")
    private String uid;    
}