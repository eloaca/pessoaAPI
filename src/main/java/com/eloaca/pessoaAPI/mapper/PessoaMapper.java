package com.eloaca.pessoaAPI.mapper;

import com.eloaca.pessoaAPI.domain.dto.PessoaDTO;
import com.eloaca.pessoaAPI.domain.entitys.Pessoa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    Pessoa toPessoa(PessoaDTO dto);
    PessoaDTO toDTO(Pessoa pessoa);
}
