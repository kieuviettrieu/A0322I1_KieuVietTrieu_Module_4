package com.codegym.model;

import com.codegym.model.facitily.Service;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "service_type")
public class ServiceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType",cascade = CascadeType.REMOVE)
    private Set<Service> service;

    public ServiceType() {
    }

    public ServiceType(int id, String serviceTypeName) {
        this.id = id;
        this.serviceTypeName = serviceTypeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int service_Type_Id) {
        this.id = service_Type_Id;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String service_Type_Name) {
        this.serviceTypeName = service_Type_Name;
    }

    public Set<Service> getService() {
        return service;
    }

    public void setService(Set<Service> service) {
        this.service = service;
    }
}
