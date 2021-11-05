package com.eloaca.pessoaAPI.controller;

import com.eloaca.pessoaAPI.domain.dto.TelefoneDTO;
import com.eloaca.pessoaAPI.domain.entitys.Telefone;
import com.eloaca.pessoaAPI.exception.NaoEncontradoException;
import com.eloaca.pessoaAPI.service.TelefoneService;
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
@RequestMapping("/v1/telefone")
@AllArgsConstructor
public class TelefoneController {

    final TelefoneService service;

    @RequestMapping("/salvar")
    public ResponseEntity<TelefoneDTO> salvarTelefone(@RequestBody @Valid final Telefone Telefone){
        return new ResponseEntity<>(service.salvarTelefone(Telefone), HttpStatus.CREATED);
    }

    @GetMapping("/consultar/{id}")
    public ResponseEntity<TelefoneDTO> consultarTelefone(@PathVariable final Long id) throws NaoEncontradoException {
        return ResponseEntity.ok(service.consultarTelefones(id));
    }

    @GetMapping("/consultar")
    public ResponseEntity<List<TelefoneDTO>> consultarTelefones() throws NaoEncontradoException {
        return ResponseEntity.ok(service.consultarTelefones());
    }
}
