package com.ayush.service;

import com.ayush.model.Employee;
import com.ayush.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository repository;


    @Override
    public void saveEmployee(Employee employee) {
        repository.save(toEntity(employee));
    }

    @Override
    public void deleteEmployee(int employeeId) {
        repository.deleteEmp(employeeId);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Optional<com.ayush.entity.Employee> byId = repository.findById(employee.getEmpId());
        com.ayush.entity.Employee employee1 = byId.get();
        employee1.setEmail(employee.getEmail());
        employee1.setMobile(employee.getMobile());
        employee1.setName(employee.getName());
        repository.save(employee1);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return repository.findAll().stream().map(this::toModel).collect(Collectors.toList());
    }

    @Override
    public Employee getEmployeeById(int id) {
        return repository.findById(id).map(this::toModel).get();
    }

    private com.ayush.entity.Employee toEntity(Employee employee){
        com.ayush.entity.Employee entity = new com.ayush.entity.Employee();
        entity.setEmpId(employee.getEmpId());
        entity.setName(employee.getName());
        entity.setMobile(employee.getMobile());
        entity.setEmail(employee.getEmail());
        return entity;
    }
    private Employee toModel(com.ayush.entity.Employee empl){
        Employee employee = new Employee();
        employee.setEmpId(empl.getEmpId());
        employee.setEmail(empl.getEmail());
        employee.setName(empl.getName());
        employee.setMobile(empl.getMobile());
        return employee;

    }
}
