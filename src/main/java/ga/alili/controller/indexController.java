package ga.alili.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class indexController {

    @GetMapping("/")
    public String homePage(){
        return "index";
    }

    @GetMapping("/student/ajax")
    public String viewStudentsAjax(){
        return "ajax/student-list-ajax";
    }
}
