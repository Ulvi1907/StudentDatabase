package ga.alili.repository;

import ga.alili.domain.Student;
import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    List<Student> getStudentList();
    Optional<Student> getStudentById(Long id);
    Student addStudent(Student student);
    Student updateStudent(Long id, Student student);
    boolean deleteStudent(Long student_id);
}
