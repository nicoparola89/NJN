package com.entity.service;

import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.application.exceptions.BusinessException;
import com.application.exceptions.ValidationError;
import com.entity.dto.ContactoDTO;
import com.entity.dto.ContactoDTOFactory;
import com.entity.entidades.Contacto;
import com.entity.repository.ContactoRepository;

/**
 * Son los Contactos. 
 * 
 */

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ContactoService implements ContactoServiceRemote{

	@EJB
	private ContactoRepository contactoRepository;

	@EJB
	private ContactoServiceValidations validator;
	
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ContactoDTO buscarConId(Integer contactoId) {
		return ContactoDTOFactory.getContactoDTO(contactoRepository.get(contactoId));
	}

	@Override
	public Collection<ContactoDTO> listAll() {
		return ContactoDTOFactory.getContactoDTO(contactoRepository.getAll());
	}

	@Override
	public ContactoDTO addContacto(ContactoDTO contacto) {
		List<ValidationError> errors = validator.validarAddContacto(contacto);
		if (errors.size() > 0) {
			throw new BusinessException("Errores al crear un contacto.", errors);
		}
		Contacto nuevoContacto = new Contacto();
		nuevoContacto.setNombre(contacto.getNombre());
		nuevoContacto.setApellido(contacto.getApellido());
		
		validator.validarEntityBean(nuevoContacto);
		
		contactoRepository.add(nuevoContacto);
		
		return ContactoDTOFactory.getContactoDTO(nuevoContacto);
	}

}
