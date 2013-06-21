package com.entity.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.entity.entidades.Deuda;

/**
 * Abstract Factory para conversion de Entidad a DTO de Deuda.
 * 
 * 
 */

public class DeudaDTOFactory {

	/**
	 * Devuelve una DeudaDTO populado con toda la informacion posible.
	 * 
	 * @param deuda
	 * @return
	 */
	
	public static DeudaDTO getDeudaDTO(Deuda deuda) {
		
		if (deuda == null) {
			return null;
		}
		DeudaDTO result = new DeudaDTO();
		result.setId(deuda.getId());
		result.setDescripcion(deuda.getDescripcion());
		result.setEstado(deuda.getEstado());
		result.setFechaEmision(deuda.getFechaEmision());
		result.setFechaPago(deuda.getFechaPago());
		result.setMonto(deuda.getMonto());
		result.setTipoDeuda(deuda.getTipoDeuda());
		return result;		
		
	}
	
	/**
	 * Devuelve una lista de DeudaDTO populado con toda la informacion posible.
	 * 
	 * @param deudas
	 * @return
	 */
	
	public static Collection<DeudaDTO> getDeudaDTO(Collection<Deuda> deudas) {
		
		if(deudas == null) {
			return null;
		}
		
		List<DeudaDTO> retorno = new ArrayList<DeudaDTO>();
		for(Deuda deuda: deudas) {
			retorno.add(getDeudaDTO(deuda));
		}
		return retorno;
	}
		
}
