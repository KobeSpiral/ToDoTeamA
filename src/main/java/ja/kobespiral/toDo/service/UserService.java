package ja.kobespiral.toDo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ja.kobespiral.toDo.exception.UserCheckException;
import ja.kobespiral.toDo.dto.UserDto;
import ja.kobespiral.toDo.entity.User;
import ja.kobespiral.toDo.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository users;

    public User addUser(User user){
        Long uid = user.getUid();
        if (uid != null && users.findById(uid).isPresent()) {
            throw new UserCheckException(UserCheckException.USER_ALREADY_EXISTS,
            "User #" + uid + " already exists");
        } else {
            return users.save(user);
        }
    }

    public UserDto getUser(Long uid){
        User p = users.findById(uid).orElseThrow(
            ()-> new UserCheckException(UserCheckException.NO_SUCH_USER,
            "No such person #" + uid));

        return UserDto.build(p);
    }

    public List<UserDto> getAllUsers() {
        ArrayList<UserDto> list = new ArrayList<UserDto>();
        for (User p : users.findAll()) {
            list.add(UserDto.build(p));
        }
        return list;
    }
}