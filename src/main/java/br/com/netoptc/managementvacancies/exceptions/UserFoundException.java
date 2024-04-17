package br.com.netoptc.managementvacancies.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("User already exist");
    }
}
