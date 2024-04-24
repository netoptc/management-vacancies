package br.com.netoptc.managementvacancies.modules.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.netoptc.managementvacancies.modules.company.JobRepository;
import br.com.netoptc.managementvacancies.modules.company.entities.JobEntity;

@Service
public class CreateJobService {
    @Autowired
    private JobRepository jobRepository;

    public ResponseEntity<Object> execute(JobEntity jobEntity) {
        try {
            var job = this.jobRepository.save(jobEntity);
            return ResponseEntity.ok().body(job);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
