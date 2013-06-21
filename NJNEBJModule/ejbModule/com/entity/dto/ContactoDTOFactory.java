package com.entity.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.entity.entidades.Contacto;

/**
 * Abstract Factory para conversion de Entidad a DTO de Contacto.
 * 
 * 
 */

public class ContactoDTOFactory {

	/**
	 * Devuelve un ContactoDTO populado con toda la informacion posible.
	 * 
	 * @param contacto
	 * @return
	 */
	
	public static ContactoDTO getContactoDTO(Contacto contacto) {
		
		if (contacto == null) {
			return null;
		}
		ContactoDTO result = new ContactoDTO();
		result.setId(contacto.getId());
		result.setNombre(contacto.getNombre());
		result.setApellido(contacto.getApellido());
		result.setDeudas(contacto.getDeudas());
		return result;		
		
	}
	
	/**
	 * Devuelve una lista de ContactoDTO populado con toda la informacion posible.
	 * 
	 * @param contactos
	 * @return
	 */
	
	public static Collection<ContactoDTO> getContactoDTO(Collection<Contacto> contactos) {
		
		if(contactos == null) {
			return null;
		}
		
		List<ContactoDTO> retorno = new ArrayList<ContactoDTO>();
		for(Contacto contacto: contactos) {
			retorno.add(getContactoDTO(contacto));
		}
		return retorno;
	}
}
