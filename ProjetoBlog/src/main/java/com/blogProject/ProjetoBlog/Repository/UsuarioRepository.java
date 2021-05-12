package com.blogProject.ProjetoBlog.Repository;


import org.springframework.stereotype.Repository;

import com.blogProject.ProjetoBlog.Model.UsuarioModel;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UsuarioRepository  extends JpaRepository<UsuarioModel , String> {
	// método de busca cpf no repositório
 public Optional<UsuarioModel> findAllByCpf(String cpf);

 
 
 
}
