package com.alexandreTeste.awpag.api.controller;

import com.alexandreTeste.awpag.api.assembler.ParcelamentoAssembler;
import com.alexandreTeste.awpag.api.model.ParcelamentoModel;
import com.alexandreTeste.awpag.api.model.input.ParcelamentoInput;
import com.alexandreTeste.awpag.domain.model.Parcelamento;
import com.alexandreTeste.awpag.domain.repository.ParcelamentoRepository;
import com.alexandreTeste.awpag.domain.service.ParcelamentosService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/parcelamentos")
public class ParcelamentoController {

    private final ModelMapper modelMapper;
    private final ParcelamentoRepository parcelamentoRepository;
    private final ParcelamentosService parcelamentosService;
    private final ParcelamentoAssembler parcelamentoAssembler;

    @RequestMapping
    public List<ParcelamentoModel> listar(){
        return parcelamentoAssembler.toCollectionModel(parcelamentoRepository.findAll());
    }

    @GetMapping("/{parcelamentoId}")
    public ResponseEntity<ParcelamentoModel> buscar(@PathVariable long parcelamentoId){
        return parcelamentoRepository.findById(parcelamentoId)
                .map(parcelamentoAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParcelamentoModel cadastrar (@Valid @RequestBody ParcelamentoInput parcelamentoInput){
        Parcelamento novoParcelamento = parcelamentoAssembler.toEntity(parcelamentoInput);
        Parcelamento parcelamentoCadastrado = parcelamentosService.cadastrar(novoParcelamento);
        return parcelamentoAssembler.toModel(parcelamentoCadastrado);

    }


}
