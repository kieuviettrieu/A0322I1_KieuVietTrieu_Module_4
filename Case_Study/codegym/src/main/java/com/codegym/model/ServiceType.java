package com.codegym.model;

import com.codegym.model.facitily.Service;
import com.codegym.model.person.Employee;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service_type")
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer service_Type_Id;

    private String service_Type_Name;

    @OneToMany(mappedBy = "serviceType",cascade = CascadeType.REMOVE)
    private Set<Service> service;

    public ServiceType() {
    }

    public ServiceType(int service_Type_Id, String service_Type_Name) {
        this.service_Type_Id = service_Type_Id;
        this.service_Type_Name = service_Type_Name;
    }

    public int getService_Type_Id() {
        return service_Type_Id;
    }

    public void setService_Type_Id(int service_Type_Id) {
        this.service_Type_Id = service_Type_Id;
    }

    public String getService_Type_Name() {
        return service_Type_Name;
    }

    public void setService_Type_Name(String service_Type_Name) {
        this.service_Type_Name = service_Type_Name;
    }

    public Set<Service> getService() {
        return service;
    }

    public void setService(Set<Service> service) {
        this.service = service;
    }
}
