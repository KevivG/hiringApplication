package com.application.hiringapplication.candidate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.sql.Date;
import java.sql.Timestamp;

@Builder
@Getter
@AllArgsConstructor
public class CandidateResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String currentCompany;
    private String currentTitle;
    private Long phone;
    private String emailId;
    private CandidateStatus status;
    private Timestamp createdAt;
    private Date dateOfOffer;
    private Date dateOfJoining;

    public CandidateResponse(CandidateDetails candidateDetails) {
        this.id= candidateDetails.getId();
        this.firstName=candidateDetails.getFirstName();
        this.lastName=candidateDetails.getLastName();
        this.currentCompany=candidateDetails.getCurrentCompany();
        this.currentTitle= candidateDetails.getCurrentTitle();
        this.phone=candidateDetails.getPhone();
        this.emailId=candidateDetails.getEmailId();
        this.status=candidateDetails.getStatus();
        this.createdAt=candidateDetails.getCreatedAt();
        this.dateOfOffer=candidateDetails.getDateOfOffer();
        this.dateOfJoining=candidateDetails.getDateOfJoining();
    }
}
