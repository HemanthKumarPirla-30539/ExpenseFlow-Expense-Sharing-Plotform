package com.example.Splimate;

import jakarta.persistence.*;

@Entity
public class SettlementTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromMember;

    private String toMember;

    private Double amount;

    private Long groupId;

    public SettlementTransaction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromMember() {
        return fromMember;
    }

    public void setFromMember(String fromMember) {
        this.fromMember = fromMember;
    }

    public String getToMember() {
        return toMember;
    }

    public void setToMember(String toMember) {
        this.toMember = toMember;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
}