package com.eqxiu.office.recruit.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "resume_data")
public class ResumeData {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "field_id")
    private int fieldId;
    @Column(name = "resume_id")
    private String resumeId;
    @Column(name = "field_value")
    private String value;

    public ResumeData(){}

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

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
