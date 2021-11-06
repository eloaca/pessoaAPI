package com.eloaca.pessoaAPI.domain.entitys;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Pessoa {

    @ApiModelProperty(value = "Id de identificacao da Pessoa")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "Nome Completo da Pessoa")
    @NotEmpty
    @Column(nullable = false)
    private String nomeCompleto;

    @ApiModelProperty(value = "CPF Unico da Pessoa")
    @NotEmpty
    @Column(nullable = false, unique = true)
    @CPF
    private String cpf;

    @ApiModelProperty(value = "Data de Nascimento da Pessoa")
    private LocalDate dataNascimento;

    @ApiModelProperty(value = "Lista de telefones da Pessoa")
    @NotEmpty
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "telefones")
    private List<Telefone> telefones;
}
