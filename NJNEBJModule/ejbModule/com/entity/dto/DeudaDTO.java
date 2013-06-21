package com.entity.dto;

import java.util.Date;


public class DeudaDTO {
	
	private Integer id;
	private String descripcion;
	private boolean estaPagada;
	private Date fechaEmision;
	private Date fechaPago;
	private int monto;
	private boolean meDebe;
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
	public boolean getEstado() {
		return estaPagada;
	}
	public void setEstado(boolean estado) {
		this.estaPagada = estado;
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
	public boolean getTipoDeuda() {
		return meDebe;
	}
	public void setTipoDeuda(boolean meDebe) {
		this.meDebe = meDebe;
	}

	
}
