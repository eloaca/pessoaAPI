package com.eloaca.pessoaapi.service;

import com.eloaca.pessoaapi.domain.dto.PessoaDTO;
import com.eloaca.pessoaapi.domain.entitys.Pessoa;
import com.eloaca.pessoaapi.exception.NaoEncontradoException;
import com.eloaca.pessoaapi.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class PessoaServiceBean implements PessoaService {

    final PessoaRepository repository;

    @Override
    public PessoaDTO salvarPessoa(final Pessoa pessoa) {
        return new PessoaDTO(repository.save(pessoa));
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
