package ja.kobespiral.toDo.dto;

import java.util.Date;

import ja.kobespiral.toDo.entity.User;
import lombok.Data;

@Data
public class UserDto {
    private String uid;
    private String name;
    private Date createdAt;

    /**
     * ユーザーEntityからDTOを作成
     * 
     */
    public static UserDto build(User user) {
        UserDto dto = new UserDto();
        dto.uid = user.getUid();
        dto.name = user.getName();
        dto.createdAt = user.getCreatedAt();
        return dto;
    }
}