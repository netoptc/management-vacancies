package br.com.netoptc.managementvacancies.modules.company.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.netoptc.managementvacancies.exceptions.UserFoundException;
import br.com.netoptc.managementvacancies.modules.company.CompanyRepository;
import br.com.netoptc.managementvacancies.modules.company.entities.CompanyEntity;

@Service
public class CreateCompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<Object> execute(CompanyEntity companyEntity) {
        try {
            this.companyRepository
                    .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                    .ifPresent((user) -> {
                        throw new UserFoundException();
                    });

            var password = passwordEncoder.encode(companyEntity.getPassword());
            companyEntity.setPassword((password));

            var company = this.companyRepository.save(companyEntity);
            return ResponseEntity.ok().body(company);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
