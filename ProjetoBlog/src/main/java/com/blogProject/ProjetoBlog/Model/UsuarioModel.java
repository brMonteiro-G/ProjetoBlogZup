package com.blogProject.ProjetoBlog.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "usuario", uniqueConstraints = {@UniqueConstraint(columnNames= {"cpf", "email"})})
public class UsuarioModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	@Length(min = 11 , max = 11 , message = "Número de caracteres do cpf inválido")
	@NotBlank
	private String cpf;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String dataNasc;
	
	
	@OneToMany(mappedBy = "usuarioModel", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuarioModel")
	private List<CadastroModel> cadastroModel;
	
//	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
		

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public List<CadastroModel> getCadastroModel() {
		return cadastroModel;
	}

	public void setCadastroModel(List<CadastroModel> cadastroModel) {
		this.cadastroModel = cadastroModel;
	}


	
	
}

