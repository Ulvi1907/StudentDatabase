package ga.alili.controller;

import ga.alili.domain.Student;
import ga.alili.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class StudentController {
    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/")
    public ModelAndView homePage(){
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }

    @GetMapping("/student")
    public ModelAndView viewStudents(){
        ModelAndView mav = new ModelAndView("student-list");
        mav.addObject("students", studentRepository.getStudentList());
        return mav;
    }

    @GetMapping("/student/{id}")
    public ModelAndView viewStudent(@PathVariable(name = "id") long studentId ){
        ModelAndView modelAndView = new ModelAndView("student");
        Optional<Student> optionalStudent = studentRepository.getStudentById(studentId);
        optionalStudent.ifPresent(student -> modelAndView.addObject("student",student));
        return modelAndView;
    }

//    @GetMapping("/student-add")
//    public ModelAndView addStudent(){
//        ModelAndView mav = new ModelAndView("student-add");
//        return mav;
//    }

    @GetMapping("/student/new")
    public ModelAndView createStudent(){
        ModelAndView mav = new ModelAndView("student-add");
        Student student = new Student();
        mav.addObject("addStudent", student);
        return mav;
    }
    @PostMapping("/student/new")
    public ModelAndView saveStudent(@ModelAttribute("addStudent") Student student, BindingResult result){
        ModelAndView mav= new ModelAndView("index");
        studentRepository.addStudent(student);
        return mav;
    }
//    @GetMapping("/home")
//    public ModelAndView homePage(){
//        ModelAndView mav = new ModelAndView("home");
//        return mav;
//    }

//    @GetMapping("/rest")
//    @ResponseBody
//    public List<Student> getStudentRest(){
//        return studentRepository.getStudentList();
//    }

//    @GetMapping("/rest")
//    public ResponseEntity<?> getStudentRest(){
//        List<Student> students = studentRepository.getStudentList();
//        ResponseEntity<?> entity = new ResponseEntity<>(students, HttpStatus.OK);
//        return entity;
//    }
}
