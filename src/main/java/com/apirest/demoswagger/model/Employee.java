package com.apirest.demoswagger.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "emId")
@Builder
public class Employee {

    private String emId;
    private String name;
    private String designation;
    private double salary;
}
