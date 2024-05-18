package com.br.criandoapi.projeto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.br.criandoapi.projeto.model.Usuario;

public interface IUSUARIO extends JpaRepository<Usuario, Integer>{

	List<Usuario> findAll();

}
