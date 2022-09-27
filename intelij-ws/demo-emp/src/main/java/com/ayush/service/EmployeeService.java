package com.ayush.service;


import com.ayush.model.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface EmployeeService {
    public void saveEmployee(Employee employee);

    void deleteEmployee(int employeeId);

    void updateEmployee(Employee employee);

    public List<Employee> getAllEmployee();

    Employee getEmployeeById(int id);
}
