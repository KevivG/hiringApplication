package com.application.hiringapplication.candidate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/candidate")
@CrossOrigin
public class CandidateController {
    private final CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping("/create")
    public ResponseEntity create(@RequestBody CreateApplicationRequest createApplicationRequest){
        CandidateDetails candidateDetails = candidateService.create(createApplicationRequest);
        return  new ResponseEntity<>(new CandidateResponse(candidateDetails), HttpStatus.CREATED);
    }

    @PutMapping ("/{id}/status")
    public ResponseEntity changeStatus(@PathVariable long id,@RequestBody CandidateStatusDetails statusDetails){
        candidateService.changeStatus(id,statusDetails);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/view")
    public List<CandidateResponse> view(){
        List<CandidateDetails> candidates = candidateService.fetchAll();
        return candidates.stream()
                .map(CandidateDetails::toResponse)
                .collect(toList());
    }
}
