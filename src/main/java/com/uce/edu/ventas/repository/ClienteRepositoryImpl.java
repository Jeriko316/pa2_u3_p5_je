package com.uce.edu.ventas.repository;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertatar(Cliente cliente) {
		// TODO Auto-generated method stub
		System.out.println("antes de ejecutar en la base");
		this.entityManager.persist(cliente);
		System.out.println("despues de ejecutar en la base");

	}

}
