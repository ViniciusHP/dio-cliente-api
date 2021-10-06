package one.digitalinnovation.labpadroesprojetosspring.service.impl;

import one.digitalinnovation.labpadroesprojetosspring.exceptions.CepInvalidException;
import one.digitalinnovation.labpadroesprojetosspring.exceptions.ClienteNotFoundException;
import one.digitalinnovation.labpadroesprojetosspring.model.Cliente;
import one.digitalinnovation.labpadroesprojetosspring.model.ClienteRepository;
import one.digitalinnovation.labpadroesprojetosspring.model.Endereco;
import one.digitalinnovation.labpadroesprojetosspring.model.EnderecoRepository;
import one.digitalinnovation.labpadroesprojetosspring.service.ClienteService;
import one.digitalinnovation.labpadroesprojetosspring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode
 * ser injetada pelo Spring (via {@link Autowired}). Como essa classe
 * é um {@link Service}, ela será tratada como um <b>Singleton</b>
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    // Singleton: Injetar os componentes do Spring com @Autowired
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    // Strategy: Implementar os métodos definidos na interface
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) throws ClienteNotFoundException {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ClienteNotFoundException(id));
    }

    @Override
    public Cliente inserir(Cliente cliente) {
        return salvarClienteComCep(cliente);
    }

    @Override
    public Cliente atualizar(Long id, Cliente cliente) {
        buscarPorId(id);
        return salvarClienteComCep(cliente);
    }

    @Override
    public void deletar(Long id) {
        buscarPorId(id);
        clienteRepository.deleteById(id);
    }

    private Cliente salvarClienteComCep(Cliente cliente) {
        // Verificar se o Endereço do Cliente já existe (CEP)
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, chama ViaCEP e obtem endereço
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            if(novoEndereco.getCep() == null) throw new CepInvalidException(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });

        cliente.setEndereco(endereco);
        return clienteRepository.save(cliente);
    }
}
