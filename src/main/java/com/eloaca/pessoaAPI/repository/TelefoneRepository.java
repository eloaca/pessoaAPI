package com.eloaca.pessoaAPI.repository;

import com.eloaca.pessoaAPI.domain.entitys.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
