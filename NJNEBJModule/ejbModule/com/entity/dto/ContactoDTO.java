package com.entity.dto;

import java.util.List;

import com.entity.entidades.Deuda;

public class ContactoDTO {

	private Integer id = 0;
	private String nombre;
	private String apellido;
	private List<Deuda> deudas;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public List<Deuda> getDeudas() {
		return deudas;
	}
	public void setDeudas(List<Deuda> deudas) {
		this.deudas = deudas;
	}
		
}
