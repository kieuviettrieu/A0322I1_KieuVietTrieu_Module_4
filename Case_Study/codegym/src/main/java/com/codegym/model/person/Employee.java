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
    private Integer id;

    private String name;
    private Date birthday;
    private String address;
    private String idCard;
    private String phone;
    private String email;

    @ManyToOne
    @JoinColumn
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn
    private Position position;

    @ManyToOne
    @JoinColumn
    private Division division;

    private double salary;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany(mappedBy = "employee",cascade = CascadeType.REMOVE)
    private Set<Contract> contracts;

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String employee_Name) {
        this.name = employee_Name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date employee_Birthday) {
        this.birthday = employee_Birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String employee_Address) {
        this.address = employee_Address;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String employee_Id_Card) {
        this.idCard = employee_Id_Card;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String employee_Phone) {
        this.phone = employee_Phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String employee_Email) {
        this.email = employee_Email;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double employee_Salary) {
        this.salary = employee_Salary;
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
