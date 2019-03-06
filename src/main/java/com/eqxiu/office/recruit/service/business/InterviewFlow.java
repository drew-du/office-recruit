package com.eqxiu.office.recruit.service.business;

import com.eqxiu.office.recruit.register.Register;
import com.eqxiu.office.recruit.service.bean.RespBean;
import org.springframework.stereotype.Component;

@Component
public class InterviewFlow {

    @Register(key = "interview_screen", args = {"demandId", "resumes"})
    public RespBean screen(String demandId, String[] resumes){
        return new RespBean();//String[] resumes
    }

    @Register(key = "interview_interviewer", args = {"demandId", "interviewId", "interviewer", "operation"})
    public RespBean interviewer(String demandId, String interviewId, String interviewer, int operation){
        return new RespBean();
    }

    @Register(key = "interview_launch", args = {"demandId", "resumeId", "dateTime"})
    public RespBean launch(String demandId, String resumeId, String dateTime){
        return new RespBean();//interviewId
    }

    @Register(key = "interview_evaluation", args = {"interviewId", "opinion", "comment"})
    public RespBean evaluation(String interviewId, int opinion, String comment){
        return new RespBean();//evaluationId
    }

    @Register(key = "interview_results", args = {"interviewId", "opinion", "comment"})
    public RespBean results(String interviewId, int opinion, String comment){
        return new RespBean();//evaluationId
    }
}
