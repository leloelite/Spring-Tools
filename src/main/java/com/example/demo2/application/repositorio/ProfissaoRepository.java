package com.example.demo2.application.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.application.models.Profissao;

public interface ProfissaoRepository extends
JpaRepository<Profissao, Long>{

}
