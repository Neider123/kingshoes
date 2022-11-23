package com.sistema.kingshoes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.kingshoes.entities.Categoria;
import com.sistema.kingshoes.repository.ICategoriarRepository;

@RestController
@RequestMapping("/categoria")
@CrossOrigin
public class CategoriaController {
	@Autowired
	ICategoriarRepository categoriarRepository;
	
	@GetMapping
	public List<Categoria> listaCategoria(){
		return categoriarRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Categoria> getCategoriaById(@PathVariable Integer id ){
		Optional<Categoria> categoria=categoriarRepository.findById(id);
		if(categoria.isPresent()) {
			return categoria;
		}
		return null;
	}
	@PostMapping("/save")
	public Categoria postCategoria(@RequestBody Categoria categoria) {
		categoriarRepository.save(categoria);
		return categoria;
	}
	@PutMapping("/{id}")
	public Categoria putCategoria(@RequestBody Categoria categoria,@PathVariable Integer id) {
		Optional<Categoria>categoriaCurren=categoriarRepository.findById(id);
		if(categoriaCurren.isPresent()) {
			Categoria categoriaReturn=categoriaCurren.get();
			categoriaReturn.setDescripcion(categoria.getDescripcion());
			categoriarRepository.save(categoriaReturn);
			return categoriaReturn;
		}
		return null;
	}
	@DeleteMapping("/{id}")
	public Categoria deleteCategoria(@PathVariable Integer id ) {
		Optional<Categoria> c=categoriarRepository.findById(id);
		if(c.isPresent()) {
		categoriarRepository.deleteById(id);
		return c.get();
		}
		return null;
	}
	

}
