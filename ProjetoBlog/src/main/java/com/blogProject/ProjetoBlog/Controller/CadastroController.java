package com.blogProject.ProjetoBlog.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogProject.ProjetoBlog.Model.CadastroModel;
import com.blogProject.ProjetoBlog.Model.UsuarioModel;
import com.blogProject.ProjetoBlog.Repository.CadastroRepository;
import com.blogProject.ProjetoBlog.Repository.UsuarioRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/cadastro")
public class CadastroController {
	
@Autowired
public CadastroRepository cadastroRepository;


// método post para os dados de endereço
@PostMapping
public ResponseEntity<CadastroModel> postCadastro(@Valid @RequestBody CadastroModel cadastroModel){
	
	return ResponseEntity.status(HttpStatus.CREATED).body(cadastroRepository.save(cadastroModel));
}
	
	
	
}
