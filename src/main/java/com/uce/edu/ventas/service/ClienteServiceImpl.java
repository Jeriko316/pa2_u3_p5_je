package com.uce.edu.ventas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.IClienteRepository;
import com.uce.edu.ventas.repository.modelo.Cliente;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepository;

	@Override
	@Transactional(value = TxType.MANDATORY) // T2
	//Begin
	public void guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		try {
			this.clienteRepository.insertatar(cliente);
		} catch (RuntimeException e) {
			System.out.println();
		}//commit
	}

	@Override
	@Transactional(value=TxType.SUPPORTS)
	public void pruebaSupports() {
		// TODO Auto-generated method stub
		System.out.println("este es un metodo supports");
		System.out.println("prueba factura: " + TransactionSynchronizationManager.isActualTransactionActive());
		
	}

	@Override
	@Transactional(value= TxType.NEVER)
	public void pruebaNever() {
		// TODO Auto-generated method stub
		System.out.println("este es un metodo never");
		System.out.println("prueba never: " + TransactionSynchronizationManager.isActualTransactionActive());
		
	}

}
