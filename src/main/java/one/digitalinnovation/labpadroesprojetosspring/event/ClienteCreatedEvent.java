package one.digitalinnovation.labpadroesprojetosspring.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import javax.servlet.http.HttpServletResponse;

@Getter
public class ClienteCreatedEvent extends ApplicationEvent {
    private final Long id;
    private final HttpServletResponse response;

    public ClienteCreatedEvent(Object source, Long id, HttpServletResponse response) {
        super(source);
        this.id = id;
        this.response = response;
    }
}
