package one.digitalinnovation.labpadroesprojetosspring.exceptions;

import lombok.Getter;

@Getter
public class CepInvalidException extends RuntimeException{
    private final String cep;

    public CepInvalidException(String cep) {
        super("O cep " + cep + " é inválido.");
        this.cep = cep;
    }
}
