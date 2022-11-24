package com.sistema.kingshoes.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity

public class Producto implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="id_tienda")
	private Integer idTienda;
	private String nombre;
	private String color;
	@Column(name="id_marca")
	private Integer idMarca;
	@Column(name="id_categoria")
	private Integer idCategoria;
}
