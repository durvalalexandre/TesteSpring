package com.alexandreTeste.awpag.domain.model;

import com.alexandreTeste.awpag.domain.validation.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.OffsetDateTime;


@Entity
//@Table(name = "parcelamento") -- isso serve para chamar a tabela caso ela tenha um nome diferente da classe entidade
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class Parcelamento {

    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Valid
    @ConvertGroup(from = Default.class, to = ValidationGroups.ClienteId.class)
    @NotNull
    @ManyToOne
    //@JoinColumn(name = "clienteId") como o identificador do cliente é o mesmo, o manytoone sabe qual a chave da classe cliente(id)
    private Cliente cliente;

    @NotBlank
    @Size(max = 20)
    private String descricao;

    @NotNull
    @Positive
    private BigDecimal valorTotal;

    @NotNull
    @Positive
    @Max(12)
    private Integer quantidadeParcelas;

    private OffsetDateTime dataCriacao;

}


