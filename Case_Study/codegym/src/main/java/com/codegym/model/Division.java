package com.codegym.model;

import com.codegym.model.person.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "division")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "division",cascade = CascadeType.REMOVE)
    private Set<Employee> employees;

    public Division() {
    }

    public Division(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int division_Id) {
        this.id = division_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String division_Name) {
        this.name = division_Name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
