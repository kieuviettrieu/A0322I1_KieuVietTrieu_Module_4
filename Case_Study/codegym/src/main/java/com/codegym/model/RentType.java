package com.codegym.model;

import com.codegym.model.facitily.Service;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rent_type")
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rent_Type_Id;
    private String rent_Type_Name;

    @OneToMany(mappedBy = "rentType",cascade = CascadeType.REMOVE)
    private Set<Service> service;

    public RentType() {
    }

    public RentType(int rent_Type_Id, String rent_Type_Name) {
        this.rent_Type_Id = rent_Type_Id;
        this.rent_Type_Name = rent_Type_Name;
    }

    public int getRent_Type_Id() {
        return rent_Type_Id;
    }

    public void setRent_Type_Id(int rent_Type_Id) {
        this.rent_Type_Id = rent_Type_Id;
    }

    public String getRent_Type_Name() {
        return rent_Type_Name;
    }

    public void setRent_Type_Name(String rent_Type_Name) {
        this.rent_Type_Name = rent_Type_Name;
    }

    public Set<Service> getService() {
        return service;
    }

    public void setService(Set<Service> service) {
        this.service = service;
    }
}
