package br.com.netoptc.managementvacancies.modules.company;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.netoptc.managementvacancies.modules.company.entities.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
}
