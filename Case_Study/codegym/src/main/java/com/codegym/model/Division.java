package com.codegym.model;

import com.codegym.model.person.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "division")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer division_Id;

    private String division_Name;

    @OneToMany(mappedBy = "division",cascade = CascadeType.REMOVE)
    private Set<Employee> employees;

    public Division() {
    }

    public Division(int division_Id, String division_Name) {
        this.division_Id = division_Id;
        this.division_Name = division_Name;
    }

    public int getDivision_Id() {
        return division_Id;
    }

    public void setDivision_Id(int division_Id) {
        this.division_Id = division_Id;
    }

    public String getDivision_Name() {
        return division_Name;
    }

    public void setDivision_Name(String division_Name) {
        this.division_Name = division_Name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
