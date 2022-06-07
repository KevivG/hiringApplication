package com.application.hiringapplication.candidate;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "candidate")
@EqualsAndHashCode
public class CandidateDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "current_company")
    private String currentCompany;

    @Column(name = "current_title")
    private String currentTitle;

    @Column(name = "phone",columnDefinition = "NUMERIC")
    private Long phone;

    @Column(name = "email_id")
    private String emailId;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private CandidateStatus status;

    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "date_of_offer")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date dateOfOffer;

    @Column(name = "date_of_joining")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date dateOfJoining;

    public CandidateDetails(String firstName, String lastName, String currentCompany, String currentTitle, Long phone, String emailId, CandidateStatus created) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.currentCompany=currentCompany;
        this.currentTitle=currentTitle;
        this.phone=phone;
        this.emailId=emailId;
        this.status= CandidateStatus.valueOf(created.toString());
    }
    public CandidateResponse toResponse() {
        return CandidateResponse.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .currentCompany(currentCompany)
                .currentTitle(currentTitle)
                .phone(phone)
                .emailId(emailId)
                .status(status)
                .createdAt(createdAt)
                .dateOfOffer(dateOfOffer)
                .dateOfJoining(dateOfJoining)
                .build();
    }
}
