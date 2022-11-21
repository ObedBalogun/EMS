package com.ems.ems.Services;


import com.ems.ems.Exceptions.EmployeeObjectException;
import com.ems.ems.Models.Employee;
import com.ems.ems.Repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

//@AllArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;


    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public List <Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }
    public Employee getEmployeeByEmail(String email) {
        return employeeRepo.findEmployeeByEmail(email).orElseThrow(() -> new EmployeeObjectException("Employee with email "
                + email + " not found"));
    }

    public Employee addEmployee(Employee employee) throws Exception {
        employee.setEmployeeId("EMP-" + (UUID.randomUUID().toString().substring(0, 4)));
        if (employee.getPhoneNumber().length() != 11) {
            throw new EmployeeObjectException("Phone number not valid");
        } else if (employee.getFirstName() == null) {
            throw new Exception("First name cannot be null");
        } else if (employee.getLastName() == null) {
            throw new Exception("Last name cannot be null");
        } else if (employee.getEmail() == null) {
            throw new Exception("Email cannot be null");
        }  else {
            return employeeRepo.insert(employee);
        }
    }

}


