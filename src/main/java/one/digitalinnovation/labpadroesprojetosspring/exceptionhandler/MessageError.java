package one.digitalinnovation.labpadroesprojetosspring.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageError {
    private final String message;
}
