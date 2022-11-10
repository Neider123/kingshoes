package com.sistema.kingshoes.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	private Integer cedula;
	private String nombre;
	private String apellido;
	private String correo;
	private String contraseña;
	private String sexo;
	private String estado;
	
	

}
