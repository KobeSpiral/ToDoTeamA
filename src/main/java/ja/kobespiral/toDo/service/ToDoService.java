package ja.kobespiral.toDo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ja.kobespiral.toDo.dto.ToDoDto;
import ja.kobespiral.toDo.entity.ToDo;
import ja.kobespiral.toDo.repository.ToDoRepository;

@Service
public class ToDoService {
    @Autowired
    ToDoRepository todos;

    public ToDoDto addToDo(ToDo todo){
        return ToDoDto.build(todos.save(todo));
    }
    
    public List<ToDoDto> getToDo(String uid){
        ArrayList<ToDoDto> list = new ArrayList<ToDoDto>();
        for(ToDo d: todos.findAll()){
            list.add(ToDoDto.build(d));
        }
        return list;
    }
        

    public List<ToDoDto>  getAllToDo(){
        return null;
    }

    public ToDoDto updateToDo(ToDo todo){
        return null;
    }
}