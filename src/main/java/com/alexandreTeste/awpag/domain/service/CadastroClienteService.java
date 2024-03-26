package com.alexandreTeste.awpag.domain.service;

import com.alexandreTeste.awpag.domain.exception.NegocioException;
import com.alexandreTeste.awpag.domain.model.Cliente;
import com.alexandreTeste.awpag.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CadastroClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente buscar (Long clienteId){
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NegocioException("cliente nao encotrado"));
    }
    @Transactional
    public Cliente salvar (@NotNull Cliente cliente){
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail()).filter(c -> !c.equals(cliente)).isPresent();

        if (emailEmUso){
            throw new NegocioException("já existe esse email na base de dados");
        }
        return clienteRepository.save(cliente);
    }
    @Transactional
    public void excluir (Long clienteId){clienteRepository.deleteById(clienteId);
    }
}
