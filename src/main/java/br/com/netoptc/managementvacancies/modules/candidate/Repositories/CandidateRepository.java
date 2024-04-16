package br.com.netoptc.managementvacancies.modules.candidate.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.netoptc.managementvacancies.modules.candidate.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, UUID> {

}
