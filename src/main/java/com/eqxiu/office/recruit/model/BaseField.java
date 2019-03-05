package com.eqxiu.office.recruit.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "base_field")
public class BaseField {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "field_id")
    private int fieldId;
    @Column(name = "type")
    private String type;
    @Column(name = "field_value")
    private String value;

    public BaseField(){}

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
