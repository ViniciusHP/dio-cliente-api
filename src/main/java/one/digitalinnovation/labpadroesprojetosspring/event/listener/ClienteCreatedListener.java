package one.digitalinnovation.labpadroesprojetosspring.event.listener;

import one.digitalinnovation.labpadroesprojetosspring.event.ClienteCreatedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;

@Component
public class ClienteCreatedListener implements ApplicationListener<ClienteCreatedEvent> {
    @Override
    public void onApplicationEvent(ClienteCreatedEvent event) {
        HttpServletResponse response = event.getResponse();

        String location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(event.getId())
                        .toUri()
                        .toASCIIString();

        response.setHeader(HttpHeaders.LOCATION, location);
    }
}
