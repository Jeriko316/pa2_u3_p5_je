package com.uce.edu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.AutorLibro;
import com.uce.edu.ventas.repository.modelo.Hotel;
import com.uce.edu.ventas.repository.modelo.Libro2;
import com.uce.edu.ventas.service.IFacturaService;
import com.uce.edu.ventas.service.IHotelService;
import com.uce.edu.ventas.service.ILibroService;

@SpringBootApplication
public class Pa2U3P5JeApplication implements CommandLineRunner {

	@Autowired
	private IFacturaService iFacturaService;

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
		System.out.println("INNER JOIN N° 1");
		List<Libro2> lista = this.libroService.buscarLibroInnerJoin();
		for (Libro2 f : lista) {
			System.out.println(f);
		}

		System.out.println("RIGTH JOIN N° 1");
		List<Libro2> lista2 = this.libroService.buscarLibroRigthJoin();
		for (Libro2 f : lista2) {
			System.out.println(f);
		}

		System.out.println("LEFT JOIN N° 1");
		List<Libro2> lista3 = this.libroService.buscarLibroLeftJoin();
		for (Libro2 f : lista3) {
			System.out.println(f);
		}

		System.out.println("FULL JOINS");
		List<Libro2> lista4 = this.libroService.buscarLibroFullJoin();
		for (Libro2 f : lista4) {
			System.out.println(f);
		}

		System.out.println("FETCH JOINS");
		List<Libro2> lista5 = this.libroService.buscarLibroFetchJoin();
		for (Libro2 f : lista5) {
			System.out.println(f.getTitulo());
			for (AutorLibro d : f.getAutoresLibros()) {
				System.out.println(d.getFecha());
			}

		}
		
		System.out.println("INNER JOIN N° 2");
		List<Hotel> lista6 = this.hotelService.buscarHabitacionesInnerJoin("vip");
		for (Hotel f : lista6) {
			System.out.println("////////////////////");
			System.out.println(f);
		}

		/////////////////////////////////////////////////
		System.out.println("RIGTH JOINS n°2");
		List<Hotel> lista7 = this.hotelService.buscarHabitacionesRightJoin("normal");
		for (Hotel f : lista7) {
			System.out.println("////////////////////");
			System.out.println(f);
		}

		/////////////////////////////////////////////////
		System.out.println("LEFT JOINS n°2");
		List<Hotel> lista8 = this.hotelService.buscarHabitacionesLeftJoin("normal");
		for (Hotel f : lista8) {
			System.out.println("////////////////////");
			System.out.println(f);
		}

		/////////////////////////////////////////////////
		System.out.println("FULL JOINS n°2");
		List<Hotel> lista9 = this.hotelService.buscarHabitacionesFullJoin("normal");
		for (Hotel f : lista9) {
			System.out.println("////////////////////");
			System.out.println(f);
		}
		
		System.out.println("FETCH JOINS n°2");
		List<Hotel> lista10 = this.hotelService.buscarHotelFetchJoin();
		for (Hotel f : lista10) {
			System.out.println(f.getNombre());

		}

	}

}
