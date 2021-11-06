package com.eloaca.pessoaapi.controller;

import com.eloaca.pessoaapi.domain.dto.PessoaDTO;
import com.eloaca.pessoaapi.domain.entitys.Pessoa;
import com.eloaca.pessoaapi.exception.NaoEncontradoException;
import com.eloaca.pessoaapi.service.PessoaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/v1/pessoa")
@AllArgsConstructor
public class PessoaController {

    final PessoaService service;

    @ApiOperation(value = "Cadastrar uma nova Pessoa")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Retorna a pessoa cadastrada")
    })
    @PostMapping(value = "/salvar",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<PessoaDTO> salvarPessoa(@RequestBody @Valid final Pessoa pessoa){
        return new ResponseEntity<>(service.salvarPessoa(pessoa), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Consultar uma Pessoa pelo Id Unico")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a pessoa consultada"),
            @ApiResponse(code = 404, message = "Pessoa nao encontrada")
    })
    @GetMapping(value = "/consultar/{id}",
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PessoaDTO> consultarPessoa(@PathVariable final Long id) throws NaoEncontradoException {
        return ResponseEntity.ok(service.consultarPessoa(id));
    }

    @ApiOperation(value = "Consultar todas as Pessoas do Sistema")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna todas as pessoas consultadas"),
            @ApiResponse(code = 404, message = "Nenhuma Pessoa foi encontrada")
    })
    @GetMapping("/consultar")
    public ResponseEntity<List<PessoaDTO>> consultarPessoas() throws NaoEncontradoException{
        return ResponseEntity.ok(service.consultarPessoas());
    }
}
