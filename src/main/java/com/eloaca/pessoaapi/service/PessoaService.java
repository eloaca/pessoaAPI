package com.eloaca.pessoaapi.service;

import com.eloaca.pessoaapi.domain.dto.PessoaDTO;
import com.eloaca.pessoaapi.domain.entitys.Pessoa;
import com.eloaca.pessoaapi.exception.NaoEncontradoException;

import java.util.List;

public interface PessoaService {

    PessoaDTO salvarPessoa(final Pessoa pessoa);

    PessoaDTO consultarPessoa(final Long id) throws NaoEncontradoException;

    List<PessoaDTO> consultarPessoas() throws NaoEncontradoException;
}
