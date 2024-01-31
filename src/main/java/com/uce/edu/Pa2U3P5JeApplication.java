package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.Hotel;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;
import com.uce.edu.ventas.service.IFacturaService;
import com.uce.edu.ventas.service.IHotelService;

@SpringBootApplication
public class Pa2U3P5JeApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService iFacturaService;

	@Autowired
	private IHotelService hotelService;

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
	
		System.out.println("UPDATE");
		int cantidad =this.iFacturaService.actualizarFechas(LocalDateTime.of(2020, 1, 15, 12, 50),LocalDateTime.of(2024, 1, 26, 12, 50) );
		System.out.println("Cantidad de registros/filas actualizados");
		System.out.println(cantidad);
		
		System.out.println("Delete");
		int cantidad2 = this.iFacturaService.borrarPorNumero("001-02571");
		System.out.println("Cantidad de registros/filas borrados");
		System.out.println(cantidad2);
		
		//this.iFacturaService.eliminar(13);
		
		//DTO -> DATA TRANSFER OBJECT (es un patron de diseño para trasnferir datos dedse la capa repository hacia la service mediante un objeto)
		System.out.println("DTO");
		List<FacturaDTO> listaDTO = this.iFacturaService.buscarFacturasDTO();
		for(FacturaDTO fDTO: listaDTO) {
			System.out.println(listaDTO);
		}
		
	}

}
