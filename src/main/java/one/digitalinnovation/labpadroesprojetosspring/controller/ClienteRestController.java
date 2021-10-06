package one.digitalinnovation.labpadroesprojetosspring.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.labpadroesprojetosspring.event.ClienteCreatedEvent;
import one.digitalinnovation.labpadroesprojetosspring.model.Cliente;
import one.digitalinnovation.labpadroesprojetosspring.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda a
 * complexidade de integrações (Banco de dados em memória H2, e da API do ViaCep)
 * em uma inteface simples e coesa (API REST)
 */
@RestController
@RequestMapping("clientes")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteRestController {

    private ClienteService clienteService;
    private ApplicationEventPublisher eventPublisher;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos() {
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody @Valid Cliente cliente, HttpServletResponse response) {
        Cliente clienteSalvo = clienteService.inserir(cliente);

        eventPublisher.publishEvent(new ClienteCreatedEvent(this, cliente.getId(), response));

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id,@RequestBody @Valid Cliente cliente) {
        return ResponseEntity.ok(clienteService.atualizar(id, cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
