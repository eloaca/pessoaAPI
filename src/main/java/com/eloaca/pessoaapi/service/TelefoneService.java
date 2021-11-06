package com.eloaca.pessoaapi.service;

import com.eloaca.pessoaapi.domain.dto.TelefoneDTO;
import com.eloaca.pessoaapi.domain.entitys.Telefone;
import com.eloaca.pessoaapi.exception.NaoEncontradoException;

import java.util.List;

public interface TelefoneService {

    TelefoneDTO salvarTelefone(final Telefone telefone);

    TelefoneDTO consultarTelefone(final Long id) throws NaoEncontradoException;

    List<TelefoneDTO> consultarTelefones() throws NaoEncontradoException;
}
