package ga.alili.controller;

import ga.alili.domain.Student;
import ga.alili.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/student/api")
public class StudentControllerRest {
    private StudentRepository studentRepository;

    public StudentControllerRest(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/list/")
    public List<Student> getStudentList(){
        List<Student> students = studentRepository.getStudentList();
        students.addAll(1,students);
        return studentRepository.getStudentList();
    }

    @GetMapping("/list/{id:\\d+}")
    public Student getStudentByIdRest(@PathVariable(name = "id") Long id){
        Optional<Student> optionalStudent = studentRepository.getStudentById(id);
        if (optionalStudent.isPresent()){
            Student student = optionalStudent.get();
            return student;  }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with id " + id + " not found");
    }
    @PostMapping("/list/")
    public Student addStudent(@RequestBody Student student){
        log.debug("add new student = " + student);
        student = studentRepository.addStudent(student);
        return student;
    }

    @PutMapping("/list/{id}")
    public Student saveStudent(@RequestBody Student student, @PathVariable(name = "id") Long id){
        log.debug("insert or update student = "+student);
        Optional<Student> optionalStudent = studentRepository.getStudentById(id);
        if (optionalStudent.isPresent()){
            log.debug("student found, update");
            student = studentRepository.updateStudent(id, student);
        }
        else {
            log.debug("student not found, create new student");
            student = studentRepository.addStudent(student);
        }
        return student;
    }

    @DeleteMapping("/list/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable("id") long id){
        Optional<Student> optionalStudent = studentRepository.getStudentById(id);
        if (optionalStudent.isPresent()){
            log.debug("student found, deleting");
            boolean result = studentRepository.deleteStudent(id);
            return;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "student with id = " + id + " not found!");
    }
}
