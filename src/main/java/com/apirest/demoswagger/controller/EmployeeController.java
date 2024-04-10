package com.apirest.demoswagger.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.demoswagger.model.Employee;

@RestController
public class EmployeeController {

    List<Employee> employees = createList();

    @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
    public List<Employee> firstPage() {
        return employees;
    }

    // Método para criar uma lista de empregados
    private static List<Employee> createList() {

        List<Employee> tempEmployees = new ArrayList<>();

        Employee emp1 = Employee.builder()
                .emId("1")
                .name("Daniel")
                .designation("manager")
                .salary(2000)
                .build();

        Employee emp2 = Employee.builder()
                .emId("2")
                .name("Maria")
                .designation("developer")
                .salary(3000)
                .build();

        tempEmployees.add(emp1);
        tempEmployees.add(emp2);

        return tempEmployees;
    }

    @PostMapping
    public Employee create(@RequestBody Employee user) {
        employees.add(user);
        System.out.println("Employee:" + employees);
        return user;
    }

    @DeleteMapping(path = { "/{id}" })
    public Employee delete(@PathVariable("id") int id) {
        Employee deletedEmp = null;
        
        for (Employee emp : employees) {
            if (emp.getEmId().equals(id)) {
                employees.remove(emp);
                deletedEmp = emp;
                break;
            }
        }
        return deletedEmp;
    }

}
