package com.eloaca.pessoaAPI.mapper;

import com.eloaca.pessoaAPI.domain.dto.TelefoneDTO;
import com.eloaca.pessoaAPI.domain.entitys.Telefone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TelefoneMapper {


    Telefone toTelefone(TelefoneDTO dto);
    TelefoneDTO toDTO(Telefone telefone);
}
