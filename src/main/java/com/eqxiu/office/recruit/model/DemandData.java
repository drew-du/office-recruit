package com.eqxiu.office.recruit.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "demand_data")
public class DemandData {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "field_id")
    private int fieldId;
    @Column(name = "demand_id")
    private int demandId;
    @Column(name = "field_value")
    private String value;

    public DemandData(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public int getDemandId() {
        return demandId;
    }

    public void setDemandId(int demandId) {
        this.demandId = demandId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
