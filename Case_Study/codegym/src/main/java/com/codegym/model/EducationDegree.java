package com.codegym.model;

import com.codegym.model.person.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "education_degree")
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "educationDegree",cascade = CascadeType.REMOVE)
    private Set<Employee> employees;

    public EducationDegree() {
    }

    public EducationDegree(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int education_Degree_Id) {
        this.id = education_Degree_Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String education_Degree_Name) {
        this.name = education_Degree_Name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
