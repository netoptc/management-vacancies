package br.com.netoptc.managementvacancies.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErroMessageDTO {
    private String message;
    private String field;
}
