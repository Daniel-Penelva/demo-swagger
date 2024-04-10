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
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import com.apirest.demoswagger.model.Employee;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class EmployeeController {

    //Acessar swagger: http://localhost:8080/swagger-ui/index.html

    List<Employee> employees = createList();


    @Operation(summary = "Buscar todos empregados", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Upload de arquivo realizado com sucesso"),
        @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
        @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro ao realizar o upload de arquivo"),
})
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

    @Operation(summary = "Realiza cadastro de empregado", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Upload de arquivo realizado com sucesso"),
        @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
        @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro ao realizar o upload de arquivo"),
})
    @PostMapping
    public Employee create(@RequestBody Employee user) {
        employees.add(user);
        System.out.println("Employee:" + employees);
        return user;
    }


    @Operation(summary = "Deleta cadastro de empregado", method = "DELETE")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Upload de arquivo realizado com sucesso"),
        @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
        @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
        @ApiResponse(responseCode = "500", description = "Erro ao realizar o upload de arquivo"),
})
    @DeleteMapping(path = { "/{id}" })
    public Employee delete(@PathVariable("id") String id) {
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
