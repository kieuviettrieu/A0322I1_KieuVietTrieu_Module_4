package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String roleName;

    public Role() {
    }

    public Role(int id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int role_Id) {
        this.id = role_Id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String role_Name) {
        this.roleName = role_Name;
    }

}
