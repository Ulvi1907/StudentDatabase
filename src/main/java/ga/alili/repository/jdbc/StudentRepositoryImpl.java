package ga.alili.repository.jdbc;

import ga.alili.domain.Student;
import ga.alili.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Types;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Repository
public class StudentRepositoryImpl implements StudentRepository {
//    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate JdbcTemplate;
    private StudentRowMapper studentRowMapper;
    private SimpleJdbcCall getStudentById;
    private SimpleJdbcCall addStudent;


//    public StudentRepositoryImpl(JdbcTemplate jdbcTemplate, StudentRowMapper studentRowMapper) {
//        this.jdbcTemplate = jdbcTemplate;
//        this.studentRowMapper = studentRowMapper;
//    }
    public StudentRepositoryImpl(NamedParameterJdbcTemplate JdbcTemplate, StudentRowMapper studentRowMapper){
        this.JdbcTemplate = JdbcTemplate;
        this.studentRowMapper= studentRowMapper;
        this.getStudentById = new SimpleJdbcCall(JdbcTemplate.getJdbcTemplate())
                .withFunctionName("get_student_by_id")
                .returningResultSet("list", this.studentRowMapper);
        this.addStudent = new SimpleJdbcCall(JdbcTemplate.getJdbcTemplate())
        .withProcedureName("add_student")
        .declareParameters(
                new SqlInOutParameter("p_id", Types.BIGINT),
                new SqlParameter("p_name", Types.VARCHAR),
                new SqlParameter("p_surname", Types.VARCHAR),
                new SqlParameter("p_point", Types.BIGINT)
        );
    }

    @Override
    public List<Student> getStudentList() {
        String sql = "select id, name, surname, point " +
                "from student " +
                "order by name, surname";
        List<Student> students = JdbcTemplate.query(sql, studentRowMapper);
        return students;
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        Optional<Student> optionalStudent = Optional.empty();
        String sql = "select id, name, surname, point " +
                "from student " +
                "where id = :employee_id ";
        MapSqlParameterSource params = new MapSqlParameterSource("employee_id",id);
        List<Student> student = JdbcTemplate.query(sql, params, studentRowMapper);
        if (!student.isEmpty()) {
            optionalStudent = Optional.of(student.get(0));
        }
        return optionalStudent;
        }


    @Override
    public Optional<Student> getStudentByIdRest(Long id) {
        Optional<Student> optionalStudent = Optional.empty();
        MapSqlParameterSource params = new MapSqlParameterSource("p_student_id",id);
        Map<String, Object> map = getStudentById.execute(params);
        List<Student> list = (List<Student>) map.get("list");
        if (!list.isEmpty()){
            optionalStudent = Optional.of(list.get(0));
        }
        return optionalStudent;
    }

    @Transactional
    @Override
    public Student addStudent(Student student) {
        MapSqlParameterSource params = new MapSqlParameterSource("p_id",0)
                .addValue("p_name",student.getName())
                .addValue("p_surname",student.getSurname())
                .addValue("p_point", student.getPoint());
        String sql= "insert into student(name, surname, point) " +
                " values(:p_name, :p_surname, :p_point)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int count = JdbcTemplate.update(sql, params, keyHolder, new String[]{"id"});
        if (count>0){
            long id = keyHolder.getKey().longValue();
            student.setId(id);
            log.debug("new student id = "+ id);
        }
//        Map<String, Object> map = addStudent.execute(params);
//        student.setId((Long) map.get("p_id"));
        return student;
    }

    @Transactional
    @Override
    public Student updateStudent(Student student) {
        MapSqlParameterSource param = new MapSqlParameterSource("a_id",0)
                .addValue("a_name",student.getName())
                .addValue("a_surname",student.getSurname())
                .addValue("a_point", student.getPoint());
        String sql= "insert into student(name, surname, point) " +
                " values(:a_name, :a_surname, :a_point)";
        KeyHolder keyHolders = new GeneratedKeyHolder();
        int count = JdbcTemplate.update(sql, param, keyHolders, new String[]{"id"});
        if (count>0){
            long id = keyHolders.getKey().longValue();
            student.setId(id);
            log.debug("new student id = "+ id);
        }
//        Map<String, Object> map = addStudent.execute(params);
//        student.setId((Long) map.get("p_id"));
        return student;
    }

    @Transactional
    @Override
    public boolean deleteStudent(Long student_id) {
        String sql = "delete from student " +
                     "where id = :id ";
        MapSqlParameterSource map = new MapSqlParameterSource("id",student_id);
        int count = JdbcTemplate.update(sql,map);
        return count>0;
    }
}
