package br.com.netoptc.managementvacancies.modules.candidate.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.netoptc.managementvacancies.modules.candidate.entity.Candidate;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @PostMapping("/")
    public void create(@RequestBody Candidate candidate) {
        System.out.println(candidate);
    }
}
