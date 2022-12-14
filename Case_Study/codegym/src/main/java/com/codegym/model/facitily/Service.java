package com.codegym.model.facitily;

import com.codegym.model.RentType;
import com.codegym.model.ServiceType;
import com.codegym.model.contract.Contract;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String serviceName;
    private int service_Area;
    private double service_Cost;
    private int service_Max_People;

    @ManyToOne
    @JoinColumn
    private RentType rentType;

    @ManyToOne
    @JoinColumn
    private ServiceType serviceType;

    @OneToMany(mappedBy = "service",cascade = CascadeType.REMOVE)
    private Set<Contract> contracts;

    private String standard_Room;
    private String description_Other_Convenience;
    private double pool_Area;
    private int number_Of_Floors;

    public Service() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getService_Name() {
        return serviceName;
    }

    public void setService_Name(String service_name) {
        this.serviceName = service_name;
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
