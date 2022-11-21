package com.ems.ems.Controller;

import com.ems.ems.Models.Employee;
import com.ems.ems.Services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity <List<Employee>> getAllEmployees() throws Exception {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity <>(employees, HttpStatus.OK);
    }
//
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
//        Employee employee = employeeService.getEmployeeById(id);
//        return new ResponseEntity <>(employee, HttpStatus.OK);
//    }
    @GetMapping(value = "/{email}")
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable("email") String email) {
        Employee employee = employeeService.getEmployeeByEmail(email);
        return new ResponseEntity <>(employee, HttpStatus.OK);
    }

    @PostMapping(value="/add-employee")
    public ResponseEntity<?> addEmployee(@RequestBody  Employee employee) throws Exception {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }



}
