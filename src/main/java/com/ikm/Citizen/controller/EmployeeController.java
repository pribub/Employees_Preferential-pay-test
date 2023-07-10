package com.ikm.Citizen.controller;

import com.ikm.Citizen.model.EmployeeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;


@RestController
@RequestMapping("v1/employees")
public class EmployeeController {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @PostMapping("employee")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        String sql = "INSERT INTO employees (emp_id, name, penno, phone, date_of_birth) " +
                "VALUES (?, ?, ?, ?, ?)";

        try {
            jdbcTemplate.update(
                    sql,
                    employeeDTO.getEmp_Id(),
                    employeeDTO.getName(),
                    employeeDTO.getPenNo(),
                    employeeDTO.getPhone(),
                    employeeDTO.getDateOfBirth()
            );

            return new ResponseEntity<>("Employee created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create employee", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}