package com.codegym.model.person;

import com.codegym.model.Division;
import com.codegym.model.EducationDegree;
import com.codegym.model.Position;
import com.codegym.model.User;
import com.codegym.model.contract.Contract;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String employee_Id;

    private String employee_Name;
    private Date employee_Birthday;
    private String employee_Address;
    private String employee_Id_Card;
    private String employee_Phone;
    private String employee_Email;

    @ManyToOne
    @JoinColumn(name = "employee_Id", referencedColumnName = "education_Degree_Id")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "employee_Id", referencedColumnName = "position_Id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "employee_Id", referencedColumnName = "division_Id")
    private Division division;

    private double employee_Salary;

    @OneToOne
    @JoinColumn(name = "employee_Id", referencedColumnName = "userName")
    private User user;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.REMOVE)
    private Set<Contract> contracts;

    public Employee() {
    }

    public Employee(String employee_Id, String employee_Name, Date employee_Birthday, String employee_Address,
                    String employee_Id_Card, String employee_Phone, String employee_Email, EducationDegree educationDegree,
                    Position position, Division division, double employee_Salary, User user) {
        this.employee_Id = employee_Id;
        this.employee_Name = employee_Name;
        this.employee_Birthday = employee_Birthday;
        this.employee_Address = employee_Address;
        this.employee_Id_Card = employee_Id_Card;
        this.employee_Phone = employee_Phone;
        this.employee_Email = employee_Email;
        this.educationDegree = educationDegree;
        this.position = position;
        this.division = division;
        this.employee_Salary = employee_Salary;
        this.user = user;
    }

    public String getEmployee_Id() {
        return employee_Id;
    }

    public void setEmployee_Id(String employee_Id) {
        this.employee_Id = employee_Id;
    }

    public String getEmployee_Name() {
        return employee_Name;
    }

    public void setEmployee_Name(String employee_Name) {
        this.employee_Name = employee_Name;
    }

    public Date getEmployee_Birthday() {
        return employee_Birthday;
    }

    public void setEmployee_Birthday(Date employee_Birthday) {
        this.employee_Birthday = employee_Birthday;
    }

    public String getEmployee_Address() {
        return employee_Address;
    }

    public void setEmployee_Address(String employee_Address) {
        this.employee_Address = employee_Address;
    }

    public String getEmployee_Id_Card() {
        return employee_Id_Card;
    }

    public void setEmployee_Id_Card(String employee_Id_Card) {
        this.employee_Id_Card = employee_Id_Card;
    }

    public String getEmployee_Phone() {
        return employee_Phone;
    }

    public void setEmployee_Phone(String employee_Phone) {
        this.employee_Phone = employee_Phone;
    }

    public String getEmployee_Email() {
        return employee_Email;
    }

    public void setEmployee_Email(String employee_Email) {
        this.employee_Email = employee_Email;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public double getEmployee_Salary() {
        return employee_Salary;
    }

    public void setEmployee_Salary(double employee_Salary) {
        this.employee_Salary = employee_Salary;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
