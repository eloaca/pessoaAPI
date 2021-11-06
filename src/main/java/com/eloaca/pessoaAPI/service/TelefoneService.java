package com.eloaca.pessoaAPI.service;

import com.eloaca.pessoaAPI.domain.dto.TelefoneDTO;
import com.eloaca.pessoaAPI.domain.entitys.Telefone;
import com.eloaca.pessoaAPI.exception.NaoEncontradoException;

import java.util.List;

public interface TelefoneService {

    TelefoneDTO salvarTelefone(final Telefone telefone);

    TelefoneDTO consultarTelefone(final Long id) throws NaoEncontradoException;

    List<TelefoneDTO> consultarTelefones() throws NaoEncontradoException;
}
