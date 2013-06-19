package com.entity.entidades;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Deuda implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
}
