package com.example.demo2.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo2.DemoModel;
import com.example.demo2.repositorio.UsuarioRepository;

@Service
public class UsuarioService {
@Autowired
 private UsuarioRepository repo;

 public List<DemoModel> listAll() {
 return repo.findAll();
 }

 public void save(DemoModel usuario) {
 repo.save(usuario);
 }

 public DemoModel get(long id) {
 DemoModel usr = repo.findById(id).get();
 return usr;
 }

 public void delete(long id) {
 repo.deleteById(id);
 }
}

