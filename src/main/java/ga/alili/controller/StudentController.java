package ga.alili.controller;

import ga.alili.domain.Student;
import ga.alili.repository.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/")
    public ModelAndView viewStudents(){
        ModelAndView mav = new ModelAndView("student-list");
        mav.addObject("students", studentRepository.getStudentList());
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView viewStudent(@PathVariable(name = "id") long studentId ){
        ModelAndView modelAndView = new ModelAndView("student");
        Optional<Student> optionalStudent = studentRepository.getStudentById(studentId);
        optionalStudent.ifPresent(student -> modelAndView.addObject("student",student));
        return modelAndView;
    }

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
