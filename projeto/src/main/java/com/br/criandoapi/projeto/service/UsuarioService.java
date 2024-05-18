package com.br.criandoapi.projeto.service;

import java.util.List;


import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.stereotype.Service;

import com.br.criandoapi.projeto.model.Usuario;
import com.br.criandoapi.projeto.repository.IUSUARIO;

@Service
public class UsuarioService {
	
	private	final IUSUARIO repository;
	private	final PasswordEncoder passwordEncoder;
	
	
	public UsuarioService(IUSUARIO repository) {
		this.repository = repository;
		this.passwordEncoder = new BCryptPasswordEncoder();
		
	}
	
	public List<Usuario> listarUsuario(){
		
		List<Usuario> Lista = repository.findAll();
		return Lista;
	}
	
	public Usuario criarUsuario(Usuario usuario) {
		String encoder = this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encoder);
		
		Usuario usuarioNovo = repository.save(usuario);
		return usuarioNovo;
	}
	
	public Usuario editarUsuario(Usuario usuario) {
		String encoder = this.passwordEncoder.encode(usuario.getSenha());
		usuario.setSenha(encoder);
		
		Usuario usuarioNovo = repository.save(usuario);
		return usuarioNovo;
	}
	
	public Boolean excluirUsuario(Integer id) {
		repository.deleteById(id);
	
		return true;
	}

	public Boolean validarSenha(Usuario usuario) {
		String senha = repository.getById(usuario.getId()).getSenha();
		Boolean valid = passwordEncoder.matches(usuario.getSenha(), senha);
		return valid;
	}
	
	
	

}
