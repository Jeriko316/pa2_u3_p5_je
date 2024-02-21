package com.uce.edu.ventas.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
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
	@Transactional(value = TxType.REQUIRES_NEW) // T2
	// Begin
	@Async
	public void guardar(Cliente cliente) {
		// TODO Auto-generated method stub
		System.out.println("Nombre hilo: " +Thread.currentThread().getName());
		try {
			this.clienteRepository.insertatar(cliente);
			try {
				//Buscar en el registro civil
				//Validar el buro
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (RuntimeException e) {
			System.out.println(e.getClass());
		} // commit
	}

	@Override
	@Transactional(value = TxType.SUPPORTS)
	public void pruebaSupports() {
		// TODO Auto-generated method stub
		System.out.println("este es un metodo supports");
		System.out.println("prueba factura: " + TransactionSynchronizationManager.isActualTransactionActive());

	}

	@Override
	@Transactional(value = TxType.NEVER)
	public void pruebaNever() {
		// TODO Auto-generated method stub
		System.out.println("este es un metodo never");
		System.out.println("prueba never: " + TransactionSynchronizationManager.isActualTransactionActive());

	}

}
