package com.codegym.model.contract;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int quantity;

    @ManyToOne
    @JoinColumn
    private Contract contract;

    @ManyToOne
    @JoinColumn
    private AttachService attachService;

    public ContractDetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer contract_Detail_Id) {
        this.id = contract_Detail_Id;
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

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
