package com.entity.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Contacto implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id = 0;
	private String nombre;
	private String apellido;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "contactoId")
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
	
	/**
	 * Recupero todas las deudas de este contacto.
	 * 
	 * @return
	 */
	public List<Deuda> getDeudas() {
		return deudas;
	}
	
	/**
	 * Agrego una deuda al contacto.
	 * 
	 * @param deuda
	 * 
	 */
	public void addDeuda(Deuda deuda) {
		if (deudas == null) {
			deudas = new ArrayList<Deuda>();
		}
		deudas.add(deuda);
	}
}
