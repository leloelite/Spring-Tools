package com.example.demo2.application.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo2.application.models.Usuario;
import com.example.demo2.application.repositorio.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	 private UsuarioRepository repo;

	 public List<Usuario> listAll() {
	 return repo.findAll();
	 }

	 public void save(Usuario usuario) {
	 repo.save(usuario);
	 }

	 public Usuario get(long id) {
	 Usuario usr = repo.findById(id).get();
	 return usr;
	 }

	 public void delete(long id) {
	 repo.deleteById(id);
	 }
}

