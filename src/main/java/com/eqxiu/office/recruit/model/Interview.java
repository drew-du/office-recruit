package com.eqxiu.office.recruit.model;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@Table(name = "interview")
public class Interview {
    @Id
    @Column(name = "interview_id")
    private String interviewId;
    @Column(name = "resume_id")
    private int resumeId;
    @Column(name = "demand_id")
    private int demandId;
    @Column(name = "creator")
    private String creator;
    @Column(name = "status")
    private String status;
    @Column(name = "result")
    private String result;
    @Column(name = "date_time")
    private Date dateTime;

    public Interview(){}

    public String getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(String interviewId) {
        this.interviewId = interviewId;
    }

    public int getResumeId() {
        return resumeId;
    }

    public void setResumeId(int resumeId) {
        this.resumeId = resumeId;
    }

    public int getDemandId() {
        return demandId;
    }

    public void setDemandId(int demandId) {
        this.demandId = demandId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
