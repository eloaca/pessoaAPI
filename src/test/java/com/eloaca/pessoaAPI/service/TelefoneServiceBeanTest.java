package com.eloaca.pessoaAPI.service;

import com.eloaca.pessoaAPI.domain.dto.TelefoneDTO;
import com.eloaca.pessoaAPI.domain.entitys.Telefone;
import com.eloaca.pessoaAPI.domain.enums.TipoTelefone;
import com.eloaca.pessoaAPI.exception.NaoEncontradoException;
import com.eloaca.pessoaAPI.repository.TelefoneRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TelefoneServiceBeanTest {

    @Mock
    private TelefoneRepository repository;

    @InjectMocks
    private TelefoneServiceBean bean;


    @Test
    void salvarTelefone() {
        Telefone mock = telefone();
        when(repository.save(any(Telefone.class))).thenReturn(mock);
        TelefoneDTO dto = bean.salvarTelefone(mock);
        assertNotNull(dto);
    }

    @Test
    void consultarTelefone() throws NaoEncontradoException {
        Telefone mock = telefone();
        when(repository.findById(1L)).thenReturn(java.util.Optional.of(mock));
        TelefoneDTO dto = bean.consultarTelefone(1L);
        assertNotNull(dto);
    }

    @Test
    void testConsultarTelefones() throws NaoEncontradoException {
        List<Telefone> mocks = new ArrayList<>();
        mocks.add(telefone());
        when(repository.findAll()).thenReturn(mocks);
        List<TelefoneDTO> dtos = bean.consultarTelefones();
        assertEquals(mocks.get(0).getNumero(), dtos.get(0).getNumero());
    }

    @Test
    void testeConsultarTelefoneENaoEncontrar() {
        Optional<Telefone> mock = Optional.empty();
        when(repository.findById(2L)).thenReturn(mock);
        NaoEncontradoException exception = assertThrows(
                NaoEncontradoException.class,
                () -> bean.consultarTelefone(2L)
        );
        assertEquals("Telefone Nao Encontrado", exception.getMessage());
    }

    @Test
    void consultarTelefonesENaoEncontrar() {
        List<Telefone> mocks = new ArrayList<>();
        when(repository.findAll()).thenReturn(mocks);
        NaoEncontradoException exception = assertThrows(
                NaoEncontradoException.class,
                () -> bean.consultarTelefones()
        );
        assertEquals("Telefone Nao Encontrado", exception.getMessage());
    }

    private Telefone telefone(){
        return new Telefone(1L, TipoTelefone.Celular, "1996361440");
    }
}