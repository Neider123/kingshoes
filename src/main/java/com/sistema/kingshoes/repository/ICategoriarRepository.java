package com.sistema.kingshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.kingshoes.entities.Categoria;

public interface ICategoriarRepository extends JpaRepository<Categoria, Integer> {

}
