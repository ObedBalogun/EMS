package com.ems.ems.Repo;

import com.ems.ems.Models.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface EmployeeRepo extends MongoRepository<Employee, String> {
    Optional <Employee> findEmployeeByEmail(String email);
}

