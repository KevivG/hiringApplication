package com.application.hiringapplication.candidate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
@EqualsAndHashCode
public class CreateApplicationRequest {
    private String firstName;
    private String lastName;
    private String currentCompany;
    private String currentTitle;
    private Long phone;
    private String emailId;
}
