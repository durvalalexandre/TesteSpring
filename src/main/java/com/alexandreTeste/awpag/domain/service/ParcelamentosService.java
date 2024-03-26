package com.alexandreTeste.awpag.domain.service;

import com.alexandreTeste.awpag.domain.exception.NegocioException;
import com.alexandreTeste.awpag.domain.model.Cliente;
import com.alexandreTeste.awpag.domain.model.Parcelamento;
import com.alexandreTeste.awpag.domain.repository.ClienteRepository;
import com.alexandreTeste.awpag.domain.repository.ParcelamentoRepository;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Objects;

@AllArgsConstructor
@Service
public class ParcelamentosService {

    private final ParcelamentoRepository parcelamentoRepository;
    private final CadastroClienteService cadastroClienteService;
    @Transactional
    public Parcelamento cadastrar(Parcelamento novoParcelamento){


        if(novoParcelamento.getId() != null ){
            throw new NegocioException("parcelamento que esta sendo cadastrado já tem ID cadastrado");
        }

        Cliente cliente = cadastroClienteService.buscar(novoParcelamento.getCliente().getId());

        novoParcelamento.setCliente(cliente);
        novoParcelamento.setDataCriacao(OffsetDateTime.now());

        return parcelamentoRepository.save(novoParcelamento);
    }
}
