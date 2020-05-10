package com.example.demo2.application.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo2.application.models.Usuario;

public interface UsuarioRepository extends
JpaRepository<Usuario, Long>{

}
