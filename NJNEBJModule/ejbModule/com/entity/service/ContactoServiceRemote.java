package com.entity.service;

import java.util.Collection;

import javax.ejb.Remote;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.entity.dto.ContactoDTO;



@Remote
public interface ContactoServiceRemote {
	/**
	 * Busca un contacto por su id.
	 * 
	 * @param contactoId
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public abstract ContactoDTO buscarConId(Integer contactoId);
	
	/**
	 * Lista todos los contactos de la base de datos.
	 * 
	 * @return
	 */
	public abstract Collection<ContactoDTO> listAll();
	
	/**
	 * Agrega un contacto a la base de datos.
	 * 
	 * @param contacto
	 * @return
	 */
	ContactoDTO addContacto(ContactoDTO contacto);
}
