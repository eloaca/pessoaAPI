package com.eloaca.pessoaAPI.controller;

import com.eloaca.pessoaAPI.domain.dto.PessoaDTO;
import com.eloaca.pessoaAPI.domain.entitys.Pessoa;
import com.eloaca.pessoaAPI.exception.NaoEncontradoException;
import com.eloaca.pessoaAPI.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/v1/pessoa")
@AllArgsConstructor
public class PessoaController {

    final PessoaService service;

    @RequestMapping("/salvar")
    public ResponseEntity<PessoaDTO> salvarPessoa(@RequestBody @Valid final Pessoa pessoa){
        return new ResponseEntity<>(service.salvarPessoa(pessoa), HttpStatus.CREATED);
    }

    @GetMapping("consultar/{id}")
    public ResponseEntity<PessoaDTO> consultarPessoa(@PathVariable final Long id) throws NaoEncontradoException {
        return ResponseEntity.ok(service.consultarPessoa(id));
    }

    @GetMapping
    public ResponseEntity<List<PessoaDTO>> consultarPessoas() throws NaoEncontradoException{
        return ResponseEntity.ok(service.consultarPessoas());
    }
}
