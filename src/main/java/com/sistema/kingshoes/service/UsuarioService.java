package com.sistema.kingshoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.kingshoes.entities.Usuario;
import com.sistema.kingshoes.repository.IUsuarioRepository;
@Service
@Transactional
public class UsuarioService {
	@Autowired
	private IUsuarioRepository usuarioRepository;
	
	public List<Usuario> list(){
		return usuarioRepository.findAll();
	}
	public Optional<Usuario> getUsuarioById(Integer id){
		Optional<Usuario>usuario=usuarioRepository.findById(id);
		if(usuario.isPresent()) {
			return usuario;
		}
		return null;
	}
	public Optional<Usuario> getUsuarioByCorreo(String correo){
		Optional<Usuario>usuario=usuarioRepository.findByCorreo(correo);
		if(usuario.isPresent()) {
			return usuario;
		}
		return null;
	}
	public Usuario save(Usuario usuario){
		 usuarioRepository.save(usuario);
		 return usuario;
	}
	public boolean  existeEmail(String email) {
		return usuarioRepository.existsByCorreo(email);
		
	}
	public boolean exiteById(Integer id) {
		return usuarioRepository.existsById(id);
	}
	public void delete(Integer cedula) {
		usuarioRepository.deleteById(cedula);
	}

}
