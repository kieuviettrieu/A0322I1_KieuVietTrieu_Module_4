package com.codegym.model.contract;

import com.codegym.model.facitily.Service;
import com.codegym.model.person.Customer;
import com.codegym.model.person.Employee;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contract_Id;

    private Date contract_Start_Date;
    private Date contract_End_Date;
    private double contract_Deposit;
    private double contract_Total_Money;

    @ManyToOne
    @JoinColumn(name = "contract_Id", referencedColumnName = "employee_Id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "contract_Id", referencedColumnName = "customer_Id")
    private Customer customer;
    //
    @ManyToOne
    @JoinColumn(name = "contract_Id", referencedColumnName = "service_Id")
    private Service service;

    public Contract() {
    }

    public Contract(int contract_Id, Date contract_Start_Date, Date contract_End_Date, double contract_Deposit,
                    double contract_Total_Money, Employee employee, Customer customer, Service service) {
        this.contract_Id = contract_Id;
        this.contract_Start_Date = contract_Start_Date;
        this.contract_End_Date = contract_End_Date;
        this.contract_Deposit = contract_Deposit;
        this.contract_Total_Money = contract_Total_Money;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
    }


    public int getContract_Id() {
        return contract_Id;
    }

    public void setContract_Id(int contract_Id) {
        this.contract_Id = contract_Id;
    }

    public Date getContract_Start_Date() {
        return contract_Start_Date;
    }

    public void setContract_Start_Date(Date contract_Start_Date) {
        this.contract_Start_Date = contract_Start_Date;
    }

    public Date getContract_End_Date() {
        return contract_End_Date;
    }

    public void setContract_End_Date(Date contract_End_Date) {
        this.contract_End_Date = contract_End_Date;
    }

    public double getContract_Deposit() {
        return contract_Deposit;
    }

    public void setContract_Deposit(double contract_Deposit) {
        this.contract_Deposit = contract_Deposit;
    }

    public double getContract_Total_Money() {
        return contract_Total_Money;
    }

    public void setContract_Total_Money(double contract_Total_Money) {
        this.contract_Total_Money = contract_Total_Money;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
