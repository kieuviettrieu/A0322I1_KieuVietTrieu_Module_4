package com.codegym.model;

import com.codegym.model.person.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer position_Id;

    private String position_Name;

    @OneToMany(mappedBy = "position",cascade = CascadeType.REMOVE)
    private Set<Employee> employees;

    public Position() {
    }

    public Position(int position_Id, String position_Name) {
        this.position_Id = position_Id;
        this.position_Name = position_Name;
    }

    public int getPosition_Id() {
        return position_Id;
    }

    public void setPosition_Id(int position_Id) {
        this.position_Id = position_Id;
    }

    public String getPosition_Name() {
        return position_Name;
    }

    public void setPosition_Name(String position_Name) {
        this.position_Name = position_Name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
