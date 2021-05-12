package com.blogProject.ProjetoBlog.Controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.blogProject.ProjetoBlog.Model.UsuarioModel;
import com.blogProject.ProjetoBlog.Repository.UsuarioRepository;


@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//endpoint que retornará um usuário com a lista de todos seus endereços cadastrados.
	@GetMapping("/{cpf}")
	public ResponseEntity<?> findByCpf(@PathVariable String cpf){

		
			if(cpf.length() != 11) {
				 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CPF invalido");
			}else {
				
				return ResponseEntity.ok(usuarioRepository.findAllByCpf(cpf));
			}
		
			
	
	}
	
	
	//Método post para usuário
	@PostMapping
	public ResponseEntity<?> postUsuario(@Valid @RequestBody UsuarioModel usuarioModel){
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuarioModel));
		}catch(DataIntegrityViolationException exception) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Houve um erro interno, por favor verifique se você já não possui um cadastro.");	
		}
			
		
	
	}
	
	
	
	
	
	
}

