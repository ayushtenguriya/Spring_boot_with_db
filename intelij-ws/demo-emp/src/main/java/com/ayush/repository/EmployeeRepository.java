package com.ayush.repository;

import com.ayush.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Modifying
    @Query(value = "delete from Employee e where e.empId = :empId")
    public void deleteEmp(int empId);
}
