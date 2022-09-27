package com.ayush.controller;

import com.ayush.model.Employee;
import com.ayush.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    //http://localhost:8081/swagger-ui.html

    @Autowired
    EmployeeService service;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String save(@RequestBody Employee employee) {
        service.saveEmployee(employee);
        return "Employee Saved";
    }

    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String update(@RequestBody Employee employee) {
        service.updateEmployee(employee);
        return "Employee Updated";
    }

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAllEmployee() {
        return service.getAllEmployee();
    }

    @GetMapping(value = "/get/{empId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployeeById(@PathVariable int empId) {
        return service.getEmployeeById(empId);
    }

    @DeleteMapping(value = "/delete/{empId}")
    public String deleteByEmployeeId(@PathVariable int empId) {
        service.deleteEmployee(empId);
        return "Employee Successfully Deleted.";
    }
}
