package br.com.netoptc.managementvacancies.modules.candidate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.netoptc.managementvacancies.exceptions.UserFoundException;
import br.com.netoptc.managementvacancies.modules.candidate.CandidateEntity;
import br.com.netoptc.managementvacancies.modules.candidate.CandidateRepository;

@Service
public class CreateCandidateService {
    @Autowired
    private CandidateRepository candidateRepository;

    public ResponseEntity<Object> execute(CandidateEntity candidateEntity) {
        try {
            this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                    .ifPresent((user) -> {
                        throw new UserFoundException();
                    });

            var candidate = this.candidateRepository.save(candidateEntity);
            return ResponseEntity.ok().body(candidate);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
