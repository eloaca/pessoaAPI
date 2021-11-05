package com.eloaca.pessoaAPI.domain.dto;

import com.eloaca.pessoaAPI.domain.entitys.Telefone;
import com.eloaca.pessoaAPI.domain.enums.TipoTelefone;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TelefoneDTO implements Serializable {

    private static final long serialVersionUID = -1055635774861164874L;

    private Long id;
    private TipoTelefone tipoTelefone;
    private String numero;

    public TelefoneDTO(Telefone telefone){
        this.id = telefone.getId();
        this.tipoTelefone = telefone.getTipoTelefone();
        this.numero = telefone.getNumero();
    }
}
