package com.eloaca.pessoaAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NaoEncontradoException extends Exception{

    private static final long serialVersionUID = 337519044626742076L;

    public NaoEncontradoException(String objeto){
        super(objeto  + " Nao Encontrado");
    }
}
