package com.example.demo2.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.DemoModel;

public interface UsuarioRepository extends
JpaRepository<DemoModel, Long>{

}
