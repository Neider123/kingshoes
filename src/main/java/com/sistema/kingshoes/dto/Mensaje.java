package com.sistema.kingshoes.dto;

import lombok.Data;

@Data
public class Mensaje {
	private String mensaje;
	
	public Mensaje(String mensaje) {
		this.mensaje=mensaje;
	}
}
