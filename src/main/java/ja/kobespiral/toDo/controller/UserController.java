package ja.kobespiral.toDo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ja.kobespiral.toDo.dto.UserDto;
import ja.kobespiral.toDo.entity.User;
import ja.kobespiral.toDo.form.SearchForm;
import ja.kobespiral.toDo.form.UserForm;
import ja.kobespiral.toDo.service.UserService;

@Controller
public class UserController {
    @Autowired
    UserService us;
    
    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView model = new ModelAndView();
        model.addObject("title", "ToDo App");
        model.addObject("mainContents", "/components/homeView");
        model.setViewName("./mainLayout.html");
        return model;
    }
    @GetMapping("/addUser")
    public ModelAndView addUser(){
        ModelAndView model = new ModelAndView();
        model.addObject("title", "ユーザー追加 | ToDo App");
        model.addObject("mainContents", "/components/inputForm");
        model.setViewName("./mainLayout.html");
        return model;
    }
    @GetMapping("/users")
    public ModelAndView showAllUsers(){
        ModelAndView model = new ModelAndView();
        model.addObject("title", "ユーザー一覧 | ToDo App");
        model.addObject("mainContents", "/components/allUserList");
        List<UserDto> userList = us.getAllUsers();
        model.addObject("ulist", userList);
        model.setViewName("./mainLayout.html");
        return model;
    }

    @PostMapping("/users")
    public ModelAndView addUser(@ModelAttribute("form") @Validated UserForm form,ModelAndView model){
        User u = us.addUser(form.toEntity());
        model.addObject("uid", u.getUid());
        model.addObject("name", u.getName());
        model.addObject("createdAt", u.getCreatedAt());
        model.addObject("title", "登録完了 | ToDo App");
        model.addObject("mainContents", "/components/success");
        model.setViewName("./mainLayout.html");
        return model;
    }
    /*@PostMapping("/users")
    public String addUser(@ModelAttribute("form") @Validated UserForm form,Model model) {
        
        User u = us.addUser(form.toEntity());
        model.addAttribute("uid", u.getUid());
        model.addAttribute("name", u.getName());
        model.addAttribute("createdAt", u.getCreatedAt());
        return "success";
    }*/

    /*@PostMapping("/search")
    public ModelAndView searchUser(@ModelAttribute("form") @Validated SearchForm form,ModelAndView model){
        model.addObject("title", "ユーザー検索 | ToDo App");
        String searchPath="/components/search/"+form.getUid().toString();
        model.addObject("mainContents", searchPath);
        model.setViewName("./mainLayout.html");
        return showUser(uid, model);
    }*/

    @GetMapping("/users/{uid}")
    public String showUser(@PathVariable Long uid, Model model) {
        UserDto u = us.getUser(uid);
        model.addAttribute("u", u);
        return "userinfo";
    }

    /*@GetMapping("/users")
    public String showAllUsers(Model model) {
        List<UserDto> userList = us.getAllUsers();
        model.addAttribute("ulist", userList);
        return "alluserlist";
    }*/

}