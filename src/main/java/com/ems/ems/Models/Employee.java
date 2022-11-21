package com.ems.ems.Models;

import com.mongodb.lang.NonNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@Document
public class Employee {
    @Id
    private String employeeId;
    private String firstName;
    private String lastName;
    @Indexed(unique = true)
    private String email;
    private String phoneNumber;
    private Address address;
    private String designation;
    private String department;
    private BigDecimal salary;
    private LocalDateTime joiningDate;
    private LocalDateTime leavingDate;
    private String image;


    public Employee(String employeeId, String firstName, String lastName, String phoneNumber) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phoneNumber;
    }

    public void setPhone(String phone) {
        this.phoneNumber = phone;
    }
}
