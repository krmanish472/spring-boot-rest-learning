package com.techxtor.springbootrestlearning.controller;

import com.techxtor.springbootrestlearning.model.Employee;
import com.techxtor.springbootrestlearning.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// extension of @Controller that makes use of @ResponseBody
// @ResponseBody makes sure that the return is not a jsp view/page, but the actual response to user
// @ResponseBody converts java object to JSON object
@RestController
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // http://localhost:8080/techxtor/employees
    // @RequestMapping(value = "employees", method = RequestMethod.GET)
    // @GetMapping(value = "employees") // same as above
    @GetMapping("employees") /// same as above
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployees();
    }

    // http://localhost:8080/techxtor/employee/101
    @GetMapping("employee/{eId}")
    // @PathVariable annotation can be used to handle template variables in the request URI mapping, and set them as method parameters
    // More at: https://www.baeldung.com/spring-pathvariable
    // since path variable "eId" matches method variable "eId", no need to specify attribute in @PathVariable
    // method parameters annotated with @PathVariable are required by default
    // We can set the required property of @PathVariable to false to make it optional [@PathVariable(required = false)]
    // Since the introduction of Spring 4.1, we can also use java.util.Optional<T> (available in Java 8+) to handle a non-mandatory path variable [@PathVariable Optional<String> id]
    public Employee getEmployeeById(@PathVariable int eId) {
        return employeeService.getEmployeeById(eId);
    }

    // http://localhost:8080/techxtor/employee?id=101
    @GetMapping("employee")
    // @RequestParam is used to extract query parameters, form parameters, and even files from the request
    // More at: https://www.baeldung.com/spring-request-param
    // We can also do @RequestParam(value = “id”) or @RequestParam(name = “id”)
    // since request parameter "id" does not match method variable "eId", we need to specify attribute in @RequestParam i.e "id"
    // Method parameters annotated with @RequestParam are required by default.
    // We can configure our @RequestParam to be optional, though, with the required attribute [@RequestParam(required = false)]
    // We can also set a default value to the @RequestParam by using the defaultValue attribute [@RequestParam(defaultValue = "test")]
    // Alternatively, we can wrap the parameter in Optional. [@RequestParam Optional<String> id]
    public Employee getEmployeeByQueryParam(@RequestParam("id") int eId) {
        return employeeService.getEmployeeById(eId);
    }

    @PostMapping("employee")
    // @RequestBody converts JSON to java object
    public List<Employee> addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }
}
