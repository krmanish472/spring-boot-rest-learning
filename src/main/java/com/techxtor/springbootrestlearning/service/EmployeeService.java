package com.techxtor.springbootrestlearning.service;

import com.techxtor.springbootrestlearning.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
    // Arrays.asList returns a List of a fixed size that is backed by the array passed to it. You can't add/remove elements to/from that List
    // Arrays.asList() creates an immutable list from an array
    /*private List<Employee> employeeList = Arrays.asList(
            new Employee(101, "Manish", "SSE"),
            new Employee(102, "Dinesh", "SSE"),
            new Employee(103, "Anjali", "ASE")
    );*/

    // Since list is an interface, one can’t directly instantiate it.
    // However, one can create objects of those classes which have implemented this interface and instantiate them
    private List<Employee> employeeList = new ArrayList<>(
            Arrays.asList(
                    new Employee(101, "Manish", "SSE"),
                    new Employee(102, "Dinesh", "SSE"),
                    new Employee(103, "Anjali", "ASE")
            )
    );

    public List<Employee> getEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(int eId) {
        Employee emp = new Employee();
        for (Employee employee : employeeList) {
            if (employee.geteId() == eId) {
                emp = employee;
                break;
            }
        }
        return emp;
    }

    public List<Employee> addEmployee(Employee employee) {
        // UnsupportedOperationException when using Array.asList() => Hence updated employeeList variable
         employeeList.add(employee);
        return employeeList;
    }
}
