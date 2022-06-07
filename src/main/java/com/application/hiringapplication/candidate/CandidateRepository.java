
package com.application.hiringapplication.candidate;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateDetails, Long>{

    @Modifying
    @Query("update CandidateDetails c set c.status = :status where c.id = :id")
    void setStatus(long id, CandidateStatus status);

    @Modifying
    @Query("update CandidateDetails c set c.status = :candidateStatus , c.dateOfOffer = :dateOfOffer, c.dateOfJoining = :dateOfJoining  where c.id = :id")
    void setOfferStatus(long id, CandidateStatus candidateStatus, Date dateOfOffer, Date dateOfJoining);

    List<CandidateDetails> findAllByOrderById();
}
