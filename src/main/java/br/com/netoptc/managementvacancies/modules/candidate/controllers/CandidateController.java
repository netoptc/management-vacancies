package br.com.netoptc.managementvacancies.modules.candidate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.netoptc.managementvacancies.modules.candidate.Repositories.CandidateRepository;
import br.com.netoptc.managementvacancies.modules.candidate.entity.Candidate;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping("/")
    public Candidate create(@Valid @RequestBody Candidate candidate) {
        return this.candidateRepository.save(candidate);
    }
}
