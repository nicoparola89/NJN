package com.entity.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.application.exceptions.ValidationError;
import com.entity.dto.DeudaDTO;
import com.entity.entidades.Deuda;
import com.entity.repository.DeudaRepository;
@Stateless
@LocalBean

public class DeudaServiceValidations {
	@EJB
	DeudaRepository deudaRepository;
	

	public List<ValidationError> validarAddDeuda(DeudaDTO dda) {
		List<ValidationError> errors = new ArrayList<ValidationError>();
		
		if (dda.getId()!=null) {
			Deuda deuda = deudaRepository.get(dda.getId());
			if (deuda != null){
				errors.add(new ValidationError("id","Ya existe la deuda indicada"));
			}
		}
		if (dda.getDescripcion()== null || dda.getDescripcion().length() == 0){
			errors.add(new ValidationError("Descripcion", "La descripcion de la deuda no puede ser nula"));
		}
		if (dda.getEstado()){
			errors.add(new ValidationError("Estado", "No puedes crear una dueuda ya pgada"));
		}
		if (dda.getFechaEmision() == null){
			errors.add(new ValidationError("Fecha Emision", "Debe ingresar una fecha para la deida"));
		}
		if (dda.getFechaPago() != null){
			errors.add(new ValidationError("Fecha Pago", "No puede ingresar una fecha de pago al crear una deuda"));
		}
		if (dda.getMonto()<=0){
			errors.add(new ValidationError("Monto", "No puede ingresar un monto negativo"));
		}
		
		return errors;
	}

	public void validarEntityBean(Deuda nuevaDeuda) {
		// TODO Auto-generated method stub
		
	}

	public List<ValidationError> validarCancelarDeuda(Integer deudaId) {
		List <ValidationError> errors =  new ArrayList<ValidationError>();
		
		Deuda deuda = deudaRepository.get(deudaId);
				
		return null;
	}

}
