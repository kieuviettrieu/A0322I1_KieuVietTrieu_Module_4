package com.codegym.model;

import com.codegym.model.facitily.Service;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rent_type")
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String rent_Type_Name;

    @OneToMany(mappedBy = "rentType",cascade = CascadeType.REMOVE)
    private Set<Service> service;

    public RentType() {
    }

    public RentType(int id, String rent_Type_Name) {
        this.id = id;
        this.rent_Type_Name = rent_Type_Name;
    }

    public int getId() {
        return id;
    }

    public void setId(int rent_Type_Id) {
        this.id = rent_Type_Id;
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
