package com.ayush.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {

    private int empId;
    private String email;
    private String name;
    private long mobile;

}
