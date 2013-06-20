package com.entity.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Son las deudas (o pagos) de un contacto con el usuario
 *
 */
@Entity
public class Deuda implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id = 0;
	private String descripcion;
	private String estado;
	private Date fechaEmision;
	private Date fechaPago;
	private int monto;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "deudaId")
	private TipoDeuda tipoDeuda;
	
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	public TipoDeuda getTipoDeuda() {
		return tipoDeuda;
	}
	public void setTipoDeuda(TipoDeuda tipoDeuda) {
		this.tipoDeuda = tipoDeuda;
	}
	
	
		
}
