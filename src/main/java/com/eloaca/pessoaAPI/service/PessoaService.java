package com.eloaca.pessoaAPI.service;

import com.eloaca.pessoaAPI.domain.dto.PessoaDTO;
import com.eloaca.pessoaAPI.domain.entitys.Pessoa;
import com.eloaca.pessoaAPI.exception.NaoEncontradoException;

import java.util.List;

public interface PessoaService {

    PessoaDTO salvarPessoa(final Pessoa pessoa);

    PessoaDTO consultarPessoa(final Long id) throws NaoEncontradoException;

    List<PessoaDTO> consultarPessoas() throws NaoEncontradoException;
}
