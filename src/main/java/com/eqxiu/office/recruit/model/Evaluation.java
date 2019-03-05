package com.eqxiu.office.recruit.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "evaluation")
public class Evaluation {
    @Column(name = "id")
    private int id;
    @Column(name = "interview_id")
    private String interviewId;
    @Column(name = "opinion")
    private int opinion;
    @Column(name = "comment")
    private String comment;

    public Evaluation(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(String interviewId) {
        this.interviewId = interviewId;
    }

    public int getOpinion() {
        return opinion;
    }

    public void setOpinion(int opinion) {
        this.opinion = opinion;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
