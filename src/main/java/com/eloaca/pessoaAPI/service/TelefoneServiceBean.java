package com.eloaca.pessoaAPI.service;

import com.eloaca.pessoaAPI.domain.dto.TelefoneDTO;
import com.eloaca.pessoaAPI.domain.entitys.Telefone;
import com.eloaca.pessoaAPI.exception.NaoEncontradoException;
import com.eloaca.pessoaAPI.repository.TelefoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class TelefoneServiceBean implements TelefoneService {

    final TelefoneRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public TelefoneDTO salvarTelefone(final Telefone telefone) {
        return new TelefoneDTO(repository.save(telefone));
    }

    @Override
    public TelefoneDTO consultarTelefone(final Long id) throws NaoEncontradoException {
       return new TelefoneDTO(repository.findById(id).orElseThrow(() -> new NaoEncontradoException(Telefone.class.getSimpleName())));
    }

    @Override
    public List<TelefoneDTO> consultarTelefones() throws NaoEncontradoException {
        var telefones = repository.findAll();

        if (telefones.isEmpty()) {
            throw new NaoEncontradoException(Telefone.class.getSimpleName());
        }

        return telefones.stream().map(TelefoneDTO::new).collect(Collectors.toList());
    }
}
