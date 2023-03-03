package com.kot.async.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kot.async.dto.Employee;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class EmployeeDAO {

    public static List<Employee> fetchEmployee() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File("employees.json"), new TypeReference<List<Employee>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
