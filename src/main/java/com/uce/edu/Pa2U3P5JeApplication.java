package com.uce.edu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.Cliente;
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
		//this.iFacturaService.pruebaSupports();
//		System.out.println("Nombre hilo: " +Thread.currentThread().getName());
//		long tiempoInicial = System.currentTimeMillis();
//		for(int i = 0; i<=10; i++) {
//			Cliente cliente = new Cliente();
//			cliente.setApellido("CA" + i);
//			cliente.setNombre("CN" +i);
//			this.clienteService.guardar(cliente);
//		}
//		long tiempoFinal = System.currentTimeMillis();
//		
//		long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000 ;
//		System.out.println("Tiempo transcurrido en seg: " + tiempoTranscurrido);
	
		//Programacion en paralelo(multihilo - multi Thread)
//		long tiempoInicial = System.currentTimeMillis();
//		List<Cliente> listaCliente = new ArrayList<>();
//		for(int i = 1; i<=100 ; i++) {
//			Cliente cliente = new Cliente();
//			cliente.setApellido("CA" + i);
//			cliente.setNombre("CN" +i);
//			listaCliente.add(cliente);
//		}
//		listaCliente.stream().forEach(cliente->this.clienteService.guardar(cliente));
//		long tiempoFinal = System.currentTimeMillis();
//		long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000 ;
//		System.out.println("Tiempo transcurrido en seg: " + tiempoTranscurrido);
	
		long tiempoInicial = System.currentTimeMillis();
		List<Cliente> listaCliente = new ArrayList<>();
		for(int i = 1; i<=100 ; i++) {
			Cliente cliente = new Cliente();
			cliente.setApellido("CA" + i);
			cliente.setNombre("CN" +i);
			listaCliente.add(cliente);
		}
		listaCliente.parallelStream().forEach(cliente->this.clienteService.guardar(cliente));
		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000 ;
		System.out.println("Tiempo transcurrido en seg: " + tiempoTranscurrido);
		
	}

}
