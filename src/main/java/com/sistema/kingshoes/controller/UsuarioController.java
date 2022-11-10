package com.sistema.kingshoes.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.kingshoes.dto.Mensaje;
import com.sistema.kingshoes.dto.UsuarioDto;
import com.sistema.kingshoes.entities.Usuario;
import com.sistema.kingshoes.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	/*
	@GetMapping
	public List<Usuario> list(){
		return usuarioService.list();
	}
	
	@GetMapping("/{id}")
	public Optional<Usuario> findUsuarioById(@PathVariable Integer id){
		Optional<Usuario >usuario=usuarioService.getUsuarioById(id);
		if(usuario.isPresent()) {
			return usuario;
		}
		return null;
	}
	@GetMapping("/{correo}")
	public Optional<Usuario> findUsuarioById(@PathVariable String correo){
		Optional<Usuario >usuario=usuarioService.getUsuarioByCorreo(correo);
		if(usuario.isPresent()) {
			return usuario;
		}
		return null;
	}
	
	@PostMapping
	public Usuario saveUsuario(@RequestBody Usuario usuario) {
		return usuarioService.save(usuario);
	}
	
}
*/
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findUsuarioById(@PathVariable Integer id){
		Optional<Usuario >usuario=usuarioService.getUsuarioById(id);
		if(usuario.isPresent()) {
			return new ResponseEntity(usuario.get(),HttpStatus.OK );
		}
		return null;
	}
	@GetMapping("/{correo}")
	public ResponseEntity<Usuario> findUsuarioByCorreo(@PathVariable String correo){
		Optional<Usuario >usuario=usuarioService.getUsuarioByCorreo(correo);
		if(usuario.isPresent()) {
			return new ResponseEntity(usuario.get(),HttpStatus.OK );
		}
		return null;
	}
	
	@GetMapping("/lista")
	public  ResponseEntity<List<Usuario>> list(){
		List<Usuario>list=usuarioService.list();
		return new ResponseEntity<List<Usuario>>(list,HttpStatus.OK);
	}
	@GetMapping("/detalle/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Integer id){
		
		Optional<Usuario>usuario=usuarioService.getUsuarioById(id);
		if(usuario.isPresent()) {
		return new ResponseEntity<Usuario>(usuario.get(),HttpStatus.OK );
		}else {
			return new ResponseEntity(new Mensaje("usuario no exite"),HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@GetMapping("/detalle/{email}")
	public ResponseEntity<Usuario> getByEmail(@PathVariable String email){
		if(!usuarioService.existeEmail(email)) {
			return new ResponseEntity(new Mensaje("email no existe"),HttpStatus.NOT_FOUND);
		}else {
		Optional<Usuario>usuario=usuarioService.getUsuarioByCorreo(email);
		return new ResponseEntity<Usuario>(usuario.get(),HttpStatus.OK );
		}
		
	}
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody UsuarioDto usuarioDto){
		if(StringUtils.isBlank(usuarioDto.getNombre())) {
			return new ResponseEntity(new Mensaje("El nombre no puede estar vacio"),HttpStatus.BAD_REQUEST);
			
		}
		if(usuarioService.existeEmail(usuarioDto.getCorreo())) {
			return new ResponseEntity(new Mensaje("Este Correo no existe"),HttpStatus.BAD_REQUEST);
		}
		Usuario usuario=new Usuario();
		usuario.setCedula( usuarioDto.getCedula());
		usuario.setNombre(usuarioDto.getNombre());
		usuario.setApellido(usuarioDto.getApellido());
		usuario.setCorreo(usuarioDto.getCorreo());
		usuario.setContraseña(usuarioDto.getContraseña());
		usuario.setSexo(usuarioDto.getSexo());
		usuario.setEstado(usuarioDto.getEstado());
		usuarioService.save(usuario);
		return new ResponseEntity(new Mensaje("usuario creado con exito"),HttpStatus.OK);
		
		
		
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody UsuarioDto usuarioDto){
		if(!usuarioService.exiteById(id)) {
			return new ResponseEntity(new Mensaje("usuario no exite"),HttpStatus.NOT_FOUND);
		}else {
		Usuario usuario =usuarioService.getUsuarioById(id).get();
		usuario.setCedula( usuarioDto.getCedula());
		usuario.setNombre(usuarioDto.getNombre());
		usuario.setApellido(usuarioDto.getApellido());
		usuario.setCorreo(usuarioDto.getCorreo());
		usuario.setContraseña(usuarioDto.getContraseña());
		usuario.setSexo(usuarioDto.getSexo());
		usuario.setEstado(usuarioDto.getEstado());
		
		usuarioService.save(usuario);
		return new ResponseEntity(new Mensaje("Producto Actualizado"),HttpStatus.OK);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete (@PathVariable Integer id){
		if(!usuarioService.exiteById(id)) {
			return new ResponseEntity(new Mensaje("usuario no exite"),HttpStatus.NOT_FOUND);
		}
		usuarioService.delete(id);
		return new ResponseEntity(new Mensaje("Producto Eliminado"),HttpStatus.OK);
	}
	
	
	
	
	

	
}

