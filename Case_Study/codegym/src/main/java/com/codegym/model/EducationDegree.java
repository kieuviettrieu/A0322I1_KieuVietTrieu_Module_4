package com.codegym.model;

import com.codegym.model.person.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "education_degree")
public class EducationDegree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer education_Degree_Id;

    private String education_Degree_Name;

    @OneToMany(mappedBy = "educationDegree",cascade = CascadeType.REMOVE)
    private Set<Employee> employees;

    public EducationDegree() {
    }

    public EducationDegree(int education_Degree_Id, String education_Degree_Name) {
        this.education_Degree_Id = education_Degree_Id;
        this.education_Degree_Name = education_Degree_Name;
    }

    public int getEducation_Degree_Id() {
        return education_Degree_Id;
    }

    public void setEducation_Degree_Id(int education_Degree_Id) {
        this.education_Degree_Id = education_Degree_Id;
    }

    public String getEducation_Degree_Name() {
        return education_Degree_Name;
    }

    public void setEducation_Degree_Name(String education_Degree_Name) {
        this.education_Degree_Name = education_Degree_Name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
