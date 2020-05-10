package com.profissionais.ti.application.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;

import com.profissionais.ti.application.models.Profissao;

public interface ProfissaoRepository extends
JpaRepository<Profissao, Long>{

}
