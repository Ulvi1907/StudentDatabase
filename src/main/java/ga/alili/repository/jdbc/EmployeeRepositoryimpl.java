package ga.alili.repository.jdbc;

import ga.alili.domain.Employee;
import ga.alili.repository.EmployeeRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeRepositoryimpl implements EmployeeRepository {
    private JdbcTemplate jdbcTemplate;
    private EmployeeRowMapper employeeRowMapper;

    public EmployeeRepositoryimpl(JdbcTemplate jdbcTemplate, EmployeeRowMapper employeeRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.employeeRowMapper = employeeRowMapper;
    }

    @Override
    public List<Employee> getEmployeeList() {
        String sql = "select id, name, surname, student_id " +
                "from employee " +
                "order by name, surname";
        List<Employee> employees = jdbcTemplate.query(sql,employeeRowMapper);
        return employees;
    }
}
