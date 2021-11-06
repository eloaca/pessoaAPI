package com.eloaca.pessoaapi.domain.entitys;

import com.eloaca.pessoaapi.domain.enums.TipoTelefone;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Telefone {

    @ApiModelProperty(value = "Id de identificacao do numero")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "Tipo de telefone, sendo:  Celular, Residencial ou Comercial")
    @Enumerated(EnumType.STRING)
    private TipoTelefone tipoTelefone;

    @ApiModelProperty(value = "Numero do telefone")
    @Column(nullable = false)
    @NotEmpty
    @Size(min = 10)
    private String numero;
}
