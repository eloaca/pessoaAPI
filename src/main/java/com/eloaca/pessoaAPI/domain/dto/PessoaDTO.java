package com.eloaca.pessoaAPI.domain.dto;

import com.eloaca.pessoaAPI.domain.entitys.Pessoa;
import com.eloaca.pessoaAPI.domain.entitys.Telefone;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class PessoaDTO implements Serializable {

    private static final long serialVersionUID = 9075185664310918080L;

    private Long id;
    private String nomeCompleto;
    private String cpf;
    private String dataNascimento;
    private List<TelefoneDTO> telefones;

    public PessoaDTO (Pessoa pessoa){
        this.id = pessoa.getId();
        this.nomeCompleto = pessoa.getNomeCompleto();
        this.cpf = pessoa.getCpf();
        this.dataNascimento = pessoa.getDataNascimento().format(DateTimeFormatter.ISO_LOCAL_DATE);
        this.telefones = pessoa.getTelefones().stream().map(TelefoneDTO::new).collect(Collectors.toList());
    }
}
