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
import com.entity.dto.DeudaDTO;
import com.entity.dto.DeudaDTOFactory;
import com.entity.entidades.Deuda;
import com.entity.repository.DeudaRepository;


/**
 * Son las Deudas de un contacto. 
 * 
 */

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class DeudaService implements DeudaServiceRemote{

	@EJB
	private DeudaRepository deudaRepository;
	
	@EJB
	private DeudaServiceValidations validator;

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public DeudaDTO buscarConId(Integer deudaId) {
		return DeudaDTOFactory.getDeudaDTO(deudaRepository.get(deudaId));
	}

	@Override
	public Collection<DeudaDTO> listAll(Integer contactoId) {
		return DeudaDTOFactory.getDeudaDTO(deudaRepository.getAll());
	}

	@Override
	public DeudaDTO addProducto(DeudaDTO deuda, Integer contactoId) {
		List<ValidationError> errors = validator.validarAddDeuda(deuda);
		if (errors.size() > 0) {
			throw new BusinessException("Errores al crear una deuda.", errors);
		}
		Deuda nuevaDeuda = new Deuda();
		nuevaDeuda.setDescripcion(deuda.getDescripcion());
		nuevaDeuda.setMonto(deuda.getMonto());
		nuevaDeuda.setTipoDeuda(deuda.getTipoDeuda());
		nuevaDeuda.setEstado(deuda.getEstado());
		nuevaDeuda.setFechaEmision(deuda.getFechaEmision());
		nuevaDeuda.setFechaPago(deuda.getFechaPago());
		
		validator.validarEntityBean(nuevaDeuda);
		
		deudaRepository.add(nuevaDeuda);
		
		return DeudaDTOFactory.getDeudaDTO(nuevaDeuda);
	}

	@Override
	public void cancelarDeuda(Integer deudaId) {
		
		List<ValidationError> errors = validator.validarCancelarDeuda(deudaId);
		if (errors.size() > 0) {
			throw new BusinessException("Errores al cancelar la deuda.", errors);
		}

		Deuda d = deudaRepository.get(deudaId);
		
		d.setEstado(true);

		validator.validarEntityBean(d);
		
	}	
	
}
