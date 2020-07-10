package ja.kobespiral.toDo.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ja.kobespiral.toDo.dto.ToDoDto;
import ja.kobespiral.toDo.form.CreateToDoForm;
import ja.kobespiral.toDo.service.ToDoService;
import ja.kobespiral.toDo.service.UserService;


@Controller
public class ToDoController {
    @Autowired 
    UserService us;
    @Autowired
    ToDoService ts;

    @GetMapping("/user/{uid}/todolist")
    public ModelAndView myToDoList(@PathVariable String uid){
        ModelAndView mav=new ModelAndView();
        List<ToDoDto> todoList = ts.getToDo(uid);
        mav.addObject("title", "toDoリスト | ToDo App");
        mav.addObject("tdlist",todoList);
        mav.addObject("mainContents", "/components/myToDo");
        mav.setViewName("./mainLayout.html");
        return mav;
    }

    @GetMapping("/todolist")
    public ModelAndView allToDoList(@PathVariable String uid){
        ModelAndView mav=new ModelAndView();
        List<ToDoDto> todoList = ts.getAllToDo();
        mav.addObject("title", "toDoリスト | ToDo App");
        mav.addObject("tdlist",todoList);
        mav.addObject("mainContents", "/components/allToDo");
        mav.setViewName("./mainLayout.html");
        return mav;
    }

    @GetMapping("/user/{uid}/addToDo")
    public ModelAndView addToDo(@PathVariable String uid){
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "ToDo追加 | ToDo App");
        String registerPath="/user/"+ uid + "/addToDo";
        mav.addObject("registerPath", registerPath);
        mav.addObject("mainContents", "/components/registerToDo");
        mav.setViewName("./mainLayout.html");
        return mav;
    }
    @PostMapping("/todo/update")
    @ResponseBody
    public String update(@RequestParam("tid")Long tid){
        ts.updateToDo(tid);
        return "aa";
    }

    @PostMapping("/user/{uid}/addToDo")
    public ModelAndView addUser(@PathVariable String uid, @ModelAttribute("form") @Validated CreateToDoForm form){
        ModelAndView mav = new ModelAndView();
        ToDoDto t = ts.addToDo(form.toEntity(uid));
        List<ToDoDto> todoList = ts.getToDo(uid);
        mav.addObject("title", "toDoリスト | ToDo App");
        mav.addObject("tdlist",todoList);
        mav.addObject("title", "登録完了 | ToDo App");
        mav.addObject("mainContents", "/components/myToDo");

        //String redirectPath ="forward:/user/" + uid.toString() + "/todolist";
        mav.setViewName("./mainLayout.html");
        //やること:リダイレクト時にパラメータを渡して登録完了を出す。
        return mav;
    }

}