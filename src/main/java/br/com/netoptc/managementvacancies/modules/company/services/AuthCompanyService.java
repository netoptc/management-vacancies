package br.com.netoptc.managementvacancies.modules.company.services;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.netoptc.managementvacancies.modules.company.CompanyRepository;
import br.com.netoptc.managementvacancies.modules.company.dto.AuthCompanyDTO;

@Service
public class AuthCompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername()).orElseThrow(
                () -> {
                    throw new UsernameNotFoundException("User not found");
                });
        var matchesPasswords = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        if (!matchesPasswords) {
            throw new AuthenticationException();
        }
    }
}