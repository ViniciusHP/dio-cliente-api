package one.digitalinnovation.labpadroesprojetosspring.exceptionhandler;

import lombok.AllArgsConstructor;
import one.digitalinnovation.labpadroesprojetosspring.exceptions.CepInvalidException;
import one.digitalinnovation.labpadroesprojetosspring.exceptions.ClienteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<MessageError> messageErrorList = createMessageErrorList(ex.getBindingResult());
        return ResponseEntity.badRequest().body(messageErrorList);
    }

    @ExceptionHandler({ CepInvalidException.class })
    public ResponseEntity<MessageError> handleCepInvalid(CepInvalidException ex) {
        MessageError messageError = createMessageError("cep.invalido", ex.getCep());
        return ResponseEntity.badRequest().body(messageError);
    }

    @ExceptionHandler({ClienteNotFoundException.class})
    public ResponseEntity<MessageError> handleClienteNotFound(ClienteNotFoundException ex) {
        MessageError messageError = createMessageError("cliente.nao-encontrado", ex.getId());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageError);
    }

    private List<MessageError> createMessageErrorList(BindingResult bindingResult) {
        List<MessageError> messageErrorList = new ArrayList<>();

        for(FieldError fielError : bindingResult.getFieldErrors()){
            String message = messageSource.getMessage(fielError, LocaleContextHolder.getLocale());
            messageErrorList.add(new MessageError(message));
        }
        return messageErrorList;
    }

    private MessageError createMessageError(String messageCode, Object... args) {
        String message = messageSource.getMessage(messageCode, args, LocaleContextHolder.getLocale());
        return new MessageError(message);
    }
}
