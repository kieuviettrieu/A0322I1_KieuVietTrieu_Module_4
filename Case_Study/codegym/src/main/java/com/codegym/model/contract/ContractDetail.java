package com.codegym.model.contract;

import com.codegym.model.ServiceType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contract_Detail_Id;
    private int quantity;

    @OneToOne
    @JoinColumn(name = "contract_Detail_Id", referencedColumnName = "contract_Id")
    private Contract contract;

    @ManyToMany
    @JoinColumn(name = "contract_Detail_Id", referencedColumnName = "attach_Service_Id")
    private Set<AttachService> attachServices;

    public ContractDetail() {
    }

    public ContractDetail(int contract_Detail_Id, int quantity, Contract contract, Set<AttachService> attachServices) {
        this.contract_Detail_Id = contract_Detail_Id;
        this.quantity = quantity;
        this.contract = contract;
        this.attachServices = attachServices;
    }

    public int getContract_Detail_Id() {
        return contract_Detail_Id;
    }

    public void setContract_Detail_Id(int contract_Detail_Id) {
        this.contract_Detail_Id = contract_Detail_Id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Set<AttachService> getAttachServices() {
        return attachServices;
    }

    public void setAttachServices(Set<AttachService> attachServices) {
        this.attachServices = attachServices;
    }
}
