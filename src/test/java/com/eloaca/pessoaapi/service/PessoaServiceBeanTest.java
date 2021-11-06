package com.eloaca.pessoaapi.service;

import com.eloaca.pessoaapi.domain.dto.PessoaDTO;
import com.eloaca.pessoaapi.domain.entitys.Pessoa;
import com.eloaca.pessoaapi.domain.entitys.Telefone;
import com.eloaca.pessoaapi.domain.enums.TipoTelefone;
import com.eloaca.pessoaapi.exception.NaoEncontradoException;
import com.eloaca.pessoaapi.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class PessoaServiceBeanTest {

    @Mock
    private PessoaRepository repository;

    @InjectMocks
    private PessoaServiceBean bean;

    @Test
    void salvarPessoa() {
        Pessoa mock = pessoaMock();
        when(repository.save((any(Pessoa.class)))).thenReturn((mock));
        PessoaDTO dto = bean.salvarPessoa(mock);
        assertNotNull(dto);
    }

    @Test
    void consultarPessoa() throws NaoEncontradoException {
        Pessoa mock = pessoaMock();
        when(repository.findById(1L)).thenReturn(java.util.Optional.of((mock)));
        PessoaDTO dto = bean.consultarPessoa(1L);
        assertNotNull(dto);
    }

    @Test
    void consultarPessoaENaoEncontrar() {
        Optional<Pessoa> mock = Optional.empty();
        when(repository.findById(1L)).thenReturn(mock);
        NaoEncontradoException exception = assertThrows(
                NaoEncontradoException.class,
                () -> bean.consultarPessoa(1L)
        );
        assertEquals("Pessoa Nao Encontrado", exception.getMessage());
    }

    @Test
    void consultarPessoas() throws NaoEncontradoException {
        List<Pessoa> mocks = new ArrayList<>();
        mocks.add(pessoaMock());
        when(repository.findAll()).thenReturn(mocks);
        List<PessoaDTO> dtos = bean.consultarPessoas();
        assertEquals(dtos.get(0).getCpf(), mocks.get(0).getCpf());
    }

    @Test
    void consultarPessoasENaoEncontrar() {
        List<Pessoa> mocks = new ArrayList<>();
        when(repository.findAll()).thenReturn(mocks);
        NaoEncontradoException exception = assertThrows(
                NaoEncontradoException.class,
                () -> bean.consultarPessoas()
        );
        assertEquals("Pessoa Nao Encontrado", exception.getMessage());
    }

    private List<Telefone> telefonesMock(){
        Telefone mock = new Telefone(2L, TipoTelefone.Celular, "1996361440");
        List<Telefone> mocks = new ArrayList<>();
        mocks.add(mock);
        return mocks;
    }

    private Pessoa pessoaMock() {
        return new Pessoa(1L, "Augusto", "Eloa", LocalDate.of(1996, 1,24), telefonesMock());
    }
}