package com.entity.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.application.exceptions.ValidationError;
import com.entity.dto.ContactoDTO;
import com.entity.entidades.Contacto;
import com.entity.repository.ContactoRepository;

@Stateless
@LocalBean
public class ContactoServiceValidations {
	@EJB
	ContactoRepository contactoRepository;

	public List<ValidationError> validarAddContacto(ContactoDTO contacto) {
		List<ValidationError> errors = new ArrayList<ValidationError>();
		
		if(contacto.getId() != null ){
			Contacto contact = contactoRepository.get(contacto.getId());
			if (contact != null){
				   errors.add(new ValidationError("id", "El contacto ya se encuentra creado."));
			}
		}
		
		if(contacto.getNombre() == null || contacto.getApellido() == null ){
			errors.add(new ValidationError("nombre-apellido","El nombre y el apellido no pueden estar vacios"));
		}
		
		
		return errors;
	}

	public void validarEntityBean(Contacto nuevoContacto) {
		// TODO Auto-generated method stub
		
	}

}