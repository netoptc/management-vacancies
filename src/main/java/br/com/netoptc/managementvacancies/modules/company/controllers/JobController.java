package br.com.netoptc.managementvacancies.modules.company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.netoptc.managementvacancies.modules.company.entities.JobEntity;
import br.com.netoptc.managementvacancies.modules.company.services.CreateJobService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private CreateJobService createJobService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody JobEntity job) {
        return createJobService.execute(job);
    }
}
