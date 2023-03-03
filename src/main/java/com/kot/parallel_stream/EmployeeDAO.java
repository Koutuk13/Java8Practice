package com.kot.parallel_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeeDAO {

    public static List<Employee> getEmployee(){
        List<Employee> employeeList = new ArrayList<>();

        for(int i =1; i<=1000; i++){
            employeeList.add(new Employee(i,"Employee"+i, new Random().nextInt(1000*100)));
        }
        return  employeeList;
    }
}
