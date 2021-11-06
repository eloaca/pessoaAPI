package com.eloaca.pessoaAPI.domain.dto;

import com.eloaca.pessoaAPI.domain.entitys.Pessoa;
import com.eloaca.pessoaAPI.domain.entitys.Telefone;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Setter
@Getter
public class PessoaDTO implements Serializable {

    private static final long serialVersionUID = 9075185664310918080L;

    private Long id;
    private String sobreNome;
    private String cpf;
    private String dataNascimento;
    private List<Telefone> telefones;

    public PessoaDTO (Pessoa pessoa){
        this.id = pessoa.getId();
        this.sobreNome = pessoa.getSobreNome();
        this.cpf = pessoa.getCpf();
        this.dataNascimento = pessoa.getDataNascimento().format(DateTimeFormatter.ISO_DATE);
        this.telefones = pessoa.getTelefones();
    }

}
