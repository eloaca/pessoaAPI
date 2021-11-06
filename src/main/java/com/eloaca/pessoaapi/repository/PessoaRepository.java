package com.eloaca.pessoaapi.repository;

import com.eloaca.pessoaapi.domain.entitys.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
