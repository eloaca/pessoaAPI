package com.eloaca.pessoaAPI.service;

import com.eloaca.pessoaAPI.domain.dto.PessoaDTO;
import com.eloaca.pessoaAPI.domain.entitys.Pessoa;
import com.eloaca.pessoaAPI.exception.NaoEncontradoException;
import com.eloaca.pessoaAPI.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PessoaServiceBean implements PessoaService {

    final PessoaRepository repository;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public PessoaDTO salvarPessoa(final Pessoa pessoa) {
        var p = repository.save(pessoa);
        return new PessoaDTO(pessoa);
    }

    @Override
    public PessoaDTO consultarPessoa(final Long id) throws NaoEncontradoException {
        return new PessoaDTO(repository.findById(id).orElseThrow(() -> new NaoEncontradoException(Pessoa.class.getSimpleName())));
    }

    @Override
    public List<PessoaDTO> consultarPessoas() throws NaoEncontradoException {
        var pessoas = repository.findAll();

        if (pessoas.isEmpty()) {
            throw new NaoEncontradoException(Pessoa.class.getSimpleName());
        }

        return  pessoas.stream().map(PessoaDTO::new).collect(Collectors.toList());
    }
}
