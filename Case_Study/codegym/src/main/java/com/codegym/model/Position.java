package com.codegym.model;

import com.codegym.model.person.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "position",cascade = CascadeType.REMOVE)
    private Set<Employee> employees;

    public Position() {
    }

    public Position(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int position_Id) {
        this.id = position_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String position_Name) {
        this.name = position_Name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
