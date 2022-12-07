package com.codegym.model.facitily;

import com.codegym.model.RentType;
import com.codegym.model.ServiceType;
import com.codegym.model.contract.Contract;
import com.codegym.model.person.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String service_Id;

    private String service_Name;
    private int service_Area;
    private double service_Cost;
    private int service_Max_People;

    @ManyToOne
    @JoinColumn(name = "service_Id", referencedColumnName = "rent_Type_Id")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_Id", referencedColumnName = "service_Type_Id")
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service",cascade = CascadeType.REMOVE)
    private Set<Contract> contracts;

    private String standard_Room;
    private String description_Other_Convenience;
    private double pool_Area;
    private int number_Of_Floors;

    public Service() {
    }

    public Service(String service_Id, String service_Name, int service_Area, double service_Cost, int service_Max_People,
                   RentType rentType, ServiceType serviceType, String standard_Room, String description_Other_Convenience,
                   double pool_Area, int number_Of_Floors) {
        this.service_Id = service_Id;
        this.service_Name = service_Name;
        this.service_Area = service_Area;
        this.service_Cost = service_Cost;
        this.service_Max_People = service_Max_People;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.standard_Room = standard_Room;
        this.description_Other_Convenience = description_Other_Convenience;
        this.pool_Area = pool_Area;
        this.number_Of_Floors = number_Of_Floors;
    }

    public String getService_Id() {
        return service_Id;
    }

    public void setService_Id(String service_Id) {
        this.service_Id = service_Id;
    }

    public String getService_Name() {
        return service_Name;
    }

    public void setService_Name(String service_name) {
        this.service_Name = service_name;
    }

    public int getService_Area() {
        return service_Area;
    }

    public void setService_Area(int service_area) {
        this.service_Area = service_area;
    }

    public double getService_Cost() {
        return service_Cost;
    }

    public void setService_Cost(double service_cost) {
        this.service_Cost = service_cost;
    }

    public int getService_Max_People() {
        return service_Max_People;
    }

    public void setService_Max_People(int service_max_people) {
        this.service_Max_People = service_max_people;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandard_Room() {
        return standard_Room;
    }

    public void setStandard_Room(String standard_Room) {
        this.standard_Room = standard_Room;
    }

    public String getDescription_Other_Convenience() {
        return description_Other_Convenience;
    }

    public void setDescription_Other_Convenience(String description_Other_Convenience) {
        this.description_Other_Convenience = description_Other_Convenience;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public double getPool_Area() {
        return pool_Area;
    }

    public void setPool_Area(double pool_Area) {
        this.pool_Area = pool_Area;
    }

    public int getNumber_Of_Floors() {
        return number_Of_Floors;
    }

    public void setNumber_Of_Floors(int number_Of_Floors) {
        this.number_Of_Floors = number_Of_Floors;
    }
}
