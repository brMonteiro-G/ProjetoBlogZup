package com.blogProject.ProjetoBlog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogProject.ProjetoBlog.Model.CadastroModel;

@Repository
public interface CadastroRepository extends JpaRepository<CadastroModel , Long>{

	
	
	
}
