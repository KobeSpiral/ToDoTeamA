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
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "ToDo App");
        mav.addObject("mainContents", "/components/homeView");
        mav.setViewName("./mainLayout.html");
        return mav;
    }
    @GetMapping("/addUser")
    public ModelAndView addUser(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "ユーザー追加 | ToDo App");
        mav.addObject("mainContents", "/components/inputForm");
        mav.setViewName("./mainLayout.html");
        return mav;
    }
    @GetMapping("/users")
    public ModelAndView showAllUsers(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("title", "ユーザー一覧 | ToDo App");
        mav.addObject("mainContents", "/components/allUserList");
        List<UserDto> userList = us.getAllUsers();
        mav.addObject("ulist", userList);
        mav.setViewName("./mainLayout.html");
        return mav;
    }

    @PostMapping("/users")
    public ModelAndView addUser(@ModelAttribute("form") @Validated UserForm form,ModelAndView mav){
        User u = us.addUser(form.toEntity());
        mav.addObject("uid", u.getUid());
        mav.addObject("name", u.getName());
        mav.addObject("createdAt", u.getCreatedAt());
        mav.addObject("title", "登録完了 | ToDo App");
        mav.addObject("mainContents", "/components/success");
        mav.setViewName("./mainLayout.html");
        return mav;
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
    public ModelAndView searchUser(@ModelAttribute("form") @Validated SearchForm form,ModelAndView mav){
        mav.addObject("title", "ユーザー検索 | ToDo App");
        String searchPath="/components/search/"+form.getUid().toString();
        mav.addObject("mainContents", searchPath);
        mav.setViewName("./mainLayout.html");
        return showUser(uid, mav);
    }*/

    @GetMapping("/users/{uid}")
    public String showUser(@PathVariable String uid, Model model) {
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