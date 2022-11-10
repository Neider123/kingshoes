package com.sistema.kingshoes.dto;

import lombok.Data;

@Data
public class UsuarioDto {
	private Integer cedula;
	private String nombre;
	private String apellido;
	private String correo;
	private String contraseña;
	private String sexo;
	private String estado;
}
