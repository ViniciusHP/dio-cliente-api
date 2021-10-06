package one.digitalinnovation.labpadroesprojetosspring.exceptions;

import lombok.Getter;

@Getter
public class ClienteNotFoundException extends RuntimeException{

    private final Long id;

    public ClienteNotFoundException(Long id) {
        super("Cliente de id " + id + " não foi encontrado.");
        this.id = id;
    }
}
