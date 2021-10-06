package one.digitalinnovation.labpadroesprojetosspring.service;

import one.digitalinnovation.labpadroesprojetosspring.model.Cliente;

/**
 * Interface que define o padrão Strategy
 */
public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    Cliente inserir(Cliente cliente);

    Cliente atualizar(Long id, Cliente cliente);

    void deletar(Long id);
}
