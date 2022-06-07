package com.application.hiringapplication.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class CandidateService {

    private final CandidateRepository candidateRepository;

    @Autowired
    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public CandidateDetails create(CreateApplicationRequest request) {
        CandidateDetails newCandidateDetails;
        newCandidateDetails = new CandidateDetails(request.getFirstName(), request.getLastName(), request.getCurrentCompany(), request.getCurrentTitle(),
                request.getPhone(), request.getEmailId(), CandidateStatus.CREATED);
        newCandidateDetails = candidateRepository.save(newCandidateDetails);
        return newCandidateDetails;
    }

    @Transactional
    public void changeStatus(long id, CandidateStatusDetails statusDetails) {
        CandidateStatus candidateStatus = null;
        switch (statusDetails.getStatus()) {
            case "CREATED":
                candidateStatus = CandidateStatus.CREATED;
                candidateRepository.setStatus(id, candidateStatus);
                break;

            case "TELEPHONIC":
                candidateStatus = CandidateStatus.TELEPHONIC;
                candidateRepository.setStatus(id, candidateStatus);
                break;

            case "CODE_PAIRING":
                candidateStatus = CandidateStatus.CODE_PAIRING;
                candidateRepository.setStatus(id, candidateStatus);
                break;

            case "TECH_ROUND":
                candidateStatus = CandidateStatus.TECH_ROUND;
                candidateRepository.setStatus(id, candidateStatus);
                break;

            case "REJECTED":
                candidateStatus = CandidateStatus.REJECTED;
                candidateRepository.setStatus(id, candidateStatus);
                break;

            case "OFFERED":
                candidateStatus = CandidateStatus.OFFERED;
                candidateRepository.setOfferStatus(id, candidateStatus, statusDetails.getDateOfOffer(), statusDetails.getDateOfJoining());
                break;

        }
    }

    public List<CandidateDetails> fetchAll() {
        return  candidateRepository.findAllByOrderById();
    }
}

