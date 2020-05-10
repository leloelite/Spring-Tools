package com.example.demo2.application.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "usuario")
public class Usuario {
@Id
 @GeneratedValue(strategy=GenerationType.AUTO)
 private Long id;
 private String profissao;
 
private String informacao;
 private double salario;
 private String capacitacao;

public Usuario()
 {
 }
 public Usuario(Long id, String profissao, String informacao, double salario, String capacitacao)
 {
	 this.id = id;
	 this.profissao = profissao;
	 this.informacao = informacao;
	 this.salario = salario;
	 this.capacitacao = capacitacao;
 }
 
	 public Long getId()
	 {
	 return id;
	 }
	 public void setId(Long id)
	 {
	 this.id = id;
	 }
	 public String getProfissao()
	 {
	 return profissao;
	 }
	 public void setProfissao(String profissao)
	 {
	 this.profissao = profissao;
	 }
 	public String getInformacao() {
		return informacao;
	}
	public void setInformacao(String informacao) {
		this.informacao = informacao;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getCapacitacao() {
		return capacitacao;
	}
	public void setCapacitacao(String capacitacao) {
		this.capacitacao = capacitacao;
	}

}

