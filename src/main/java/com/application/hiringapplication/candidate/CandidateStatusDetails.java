package com.application.hiringapplication.candidate;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class CandidateStatusDetails {
    private String status;
    private Date dateOfOffer;
    private Date dateOfJoining;
}
