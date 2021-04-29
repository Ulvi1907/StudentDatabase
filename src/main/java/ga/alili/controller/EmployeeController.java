package ga.alili.controller;

import ga.alili.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @GetMapping("/")
    public ModelAndView viewEmployees(){
        ModelAndView mav = new ModelAndView("employee-list");
        mav.addObject("employees", employeeRepository.getEmployeeList());
        return mav;
    }
}
