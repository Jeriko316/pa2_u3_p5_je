package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.ventas.repository.modelo.DetalleFactura;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.service.IFacturaService;

@SpringBootApplication
public class Pa2U3P5JeApplication implements CommandLineRunner{

	@Autowired
	private IFacturaService iFacturaService;
	
	//Join Types en Jakarta Persistence (Tipos de joins q se hace en jakarta)
	//1)JOIN
	// 1.1 INNER JOIN
	// 1.2 OUTER JOIN
	//    1.2.1) RIGHT
	//    1.2.2) LEFT
	//    1.2.3) FUL
	//2)JOIN WHERE
	//3)FETCH JOIN
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*Factura fact = new Factura();
		fact.setCedula("456470");
		fact.setFecha(LocalDateTime.now());
		fact.setNumero("001-02589");
		
		DetalleFactura det1 = new DetalleFactura();
		det1.setCantidad(7);
		det1.setCodigoBarras("2334499");
		det1.setFactura(fact);
		det1.setNombreProducto("Sprite");
		
		DetalleFactura det2 = new DetalleFactura();
		det2.setCantidad(22);
		det2.setCodigoBarras("9876564");
		det2.setFactura(fact);
		det2.setNombreProducto("PAN");
		
		DetalleFactura det3 = new DetalleFactura();
		det3.setCantidad(20);
		det3.setCodigoBarras("9876522");
		det3.setFactura(fact);
		det3.setNombreProducto("salchicha");
		
		List<DetalleFactura> detalle = new ArrayList<DetalleFactura>();
		detalle.add(det1);
		detalle.add(det2);
		detalle.add(det3);
		
		fact.setDetalleFactura(detalle);
		
		this.iFacturaService.guardar(fact);
		//Factura fact1 = this.iFacturaService.buscarPorNumero("001-02569");
		//for(DetalleFactura det: fact1.getDetalleFactura()) {
			//System.out.println(det.getCodigoBarras());
		//}
		System.out.println(fact);*/
		
		List<Factura>lista = this.iFacturaService.buscarFacturasInnerJoin();
		for(Factura f: lista) {
			System.out.println("////////////////////");
			System.out.println(f);
		}
		
		System.out.println("RIGTH JOINS");
		List<Factura>lista2 = this.iFacturaService.buscarFacturasRigthJoin();
		for(Factura f: lista2) {
			System.out.println("////////////////////");
			System.out.println(f.getNumero());
		}
		
		System.out.println("LEFT JOINS");
		List<Factura>lista3 = this.iFacturaService.buscarFacturasLeftJoin();
		for(Factura f: lista3) {
			System.out.println("////////////////////");
			System.out.println(f);
		}
		
		
		System.out.println("FULL JOINS");
		List<Factura>lista4 = this.iFacturaService.buscarFacturasFullJoin();
		for(Factura f: lista4) {
			System.out.println("////////////////////");
			System.out.println(f);
			for(DetalleFactura d: f.getDetalleFactura()) {
				System.out.println(d);
			}
		}
	}

}
