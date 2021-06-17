package ga.alili.controller;

import ga.alili.repository.StudentRepository;
import ga.alili.view.StudentListExcelView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class indexController {

    private StudentRepository studentRepository;

    public indexController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/")
    public String homePage(){
        return "index";
    }

    @GetMapping("/student/ajax")
    public String viewStudentsAjax(){
        return "ajax/student-list-ajax";
    }

    @GetMapping("/excel")
    public ModelAndView StudentExcel(){
        ModelAndView mav = new ModelAndView(new StudentListExcelView());
        mav.addObject("studentList", studentRepository.getStudentList());
        return mav;
    }
}
