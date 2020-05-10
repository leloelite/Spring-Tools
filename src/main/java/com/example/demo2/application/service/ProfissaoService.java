package com.example.demo2.application.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo2.application.models.Profissao;
import com.example.demo2.application.repositorio.ProfissaoRepository;

@Service
public class ProfissaoService {

	@Autowired
	 private ProfissaoRepository repo;

	 public List<Profissao> listAll() {
	 return repo.findAll();
	 }

	 public void save(Profissao profissao) {
	 repo.save(profissao);
	 }

	 public Profissao get(long id) {
	 Profissao usr = repo.findById(id).get();
	 return usr;
	 }

	 public void delete(long id) {
	 repo.deleteById(id);
	 }
}

