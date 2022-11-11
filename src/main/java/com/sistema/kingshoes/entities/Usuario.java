package com.sistema.kingshoes.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="usuario")
public class Usuario  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer cedula;
	private String nombre;
	private String apellido;
	private String correo;
	private String contraseña;
	private String sexo;
	private String estado;
	private Integer idrol;
	
	

}
