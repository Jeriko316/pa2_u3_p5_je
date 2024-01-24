package com.uce.edu;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	
	public static void main(String[] args) {
		SpringApplication.run(Pa2U3P5JeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Factura fact = new Factura();
		fact.setCedula("456456");
		fact.setFecha(LocalDateTime.now());
		fact.setNumero("001-02569");
		
		DetalleFactura det1 = new DetalleFactura();
		det1.setCantidad(4);
		det1.setCodigoBarras("2334444");
		det1.setFactura(fact);
		det1.setNombreProducto("Coca-Cola");
		
		DetalleFactura det2 = new DetalleFactura();
		det2.setCantidad(2);
		det2.setCodigoBarras("9876555");
		det2.setFactura(fact);
		det2.setNombreProducto("Leche-Vita");
		
		List<DetalleFactura> detalle = new ArrayList<DetalleFactura>();
		detalle.add(det1);
		detalle.add(det2);
		
		fact.setDetalleFactura(detalle);
		
		//this.iFacturaService.guardar(fact);
		Factura fact1 = this.iFacturaService.buscarPorNumero("001-02569");
		for(DetalleFactura det: fact1.getDetalleFactura()) {
			System.out.println(det.getCodigoBarras());
		}
		System.out.println(fact1);
	}

}
