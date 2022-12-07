package com.codegym.model.contract;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "attach_service")
public class AttachService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attach_Service_Id;

    private String attach_Service_Name;

    private double attach_Service_Cost;

    private int attach_Service_Unit;

    private String attach_Service_Status;

    @ManyToMany(mappedBy = "attachServices",cascade = CascadeType.REMOVE)
    private Set<ContractDetail> contractDetails;

    public AttachService() {
    }

    public AttachService(int attach_Service_Id, String attach_Service_Name, double attach_Service_Cost,
                         int attach_Service_Unit, String attach_Service_Status) {
        this.attach_Service_Id = attach_Service_Id;
        this.attach_Service_Name = attach_Service_Name;
        this.attach_Service_Cost = attach_Service_Cost;
        this.attach_Service_Unit = attach_Service_Unit;
        this.attach_Service_Status = attach_Service_Status;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public int getAttach_Service_Id() {
        return attach_Service_Id;
    }

    public void setAttach_Service_Id(int attach_Service_Id) {
        this.attach_Service_Id = attach_Service_Id;
    }

    public String getAttach_Service_Name() {
        return attach_Service_Name;
    }

    public void setAttach_Service_Name(String attach_Service_Name) {
        this.attach_Service_Name = attach_Service_Name;
    }

    public double getAttach_Service_Cost() {
        return attach_Service_Cost;
    }

    public void setAttach_Service_Cost(double attach_Service_Cost) {
        this.attach_Service_Cost = attach_Service_Cost;
    }

    public int getAttach_Service_Unit() {
        return attach_Service_Unit;
    }

    public void setAttach_Service_Unit(int attach_Service_Unit) {
        this.attach_Service_Unit = attach_Service_Unit;
    }

    public String getAttach_Service_Status() {
        return attach_Service_Status;
    }

    public void setAttach_Service_Status(String attach_Service_Status) {
        this.attach_Service_Status = attach_Service_Status;
    }
}
