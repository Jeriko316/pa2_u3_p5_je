package com.uce.edu;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.service.IClienteService;
import com.uce.edu.ventas.service.IFacturaService;
import com.uce.edu.ventas.service.IHotelService;
import com.uce.edu.ventas.service.ILibroService;

@SpringBootApplication
public class Pa2U3P5JeApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService iFacturaService;
	
	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IHotelService hotelService;

	@Autowired
	private ILibroService libroService;

	// Join Types en Jakarta Persistence (Tipos de joins q se hace en jakarta)
	// 1)JOIN
	// 1.1 INNER JOIN
	// 1.2 OUTER JOIN
	// 1.2.1) RIGHT
	// 1.2.2) LEFT
	// 1.2.3) FUL
	// 2)JOIN WHERE
	// 3)FETCH JOIN

	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		Factura fact = new Factura();
		fact.setCedula("12345");
		fact.setFecha(LocalDateTime.now());
		fact.setNumero("001-002");
		
		Cliente cli = new Cliente();
		cli.setApellido(null);
		cli.setNombre("edison");
		
		//this.iFacturaService.guardar(fact, cli);
		System.out.println("Main: "+ TransactionSynchronizationManager.isActualTransactionActive());

		this.iFacturaService.prueba();
	}

}
