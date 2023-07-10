package com.ikm.Citizen.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor

public class EmployeeDTO {
    private int emp_Id;
    private String name;
    private String penNo;
    private String phone;
    private Date dateOfBirth;

}
