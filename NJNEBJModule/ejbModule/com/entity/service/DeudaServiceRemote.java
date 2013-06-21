package com.entity.service;



import java.util.Collection;

import javax.ejb.Remote;

import com.entity.dto.DeudaDTO;

@Remote
public interface DeudaServiceRemote {

	/**
	 * Busca una deuda por su id.
	 * 
	 * @param deudaId
	 * @return
	 */
	DeudaDTO buscarConId(Integer deudaId);

	/**
	 * Devuelve un listado de todas las deudas de un contacto.
	 * 
	 * @param contactoId
	 * @return
	 */
	Collection<DeudaDTO> listAll(Integer contactoId);

	/**
	 * Agrega una deuda nueva.
	 * 
	 * @param deuda
	 * @param contactoId
	 * @return
	 */
	DeudaDTO addProducto(DeudaDTO deuda, Integer contactoId);
	
	/**
	 * Cancela una deuda
	 * @param deudaId
	 */
	void cancelarDeuda(Integer deudaId);
	
}

