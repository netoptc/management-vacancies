package br.com.netoptc.managementvacancies.modules.candidate.entity;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Candidate {
    private UUID id;
    private String name;
    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaço")
    private String username;
    @Email(message = "O campo [email] deve conter um e-mail valido")
    private String email;
    @Length(min = 10, max = 100, message = "O campo [password] deve conter entre (10) e (100) caracters")
    private String password;
    private String description;
    private String curriculum;
}
