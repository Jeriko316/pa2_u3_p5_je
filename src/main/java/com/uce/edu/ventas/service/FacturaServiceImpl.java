package com.uce.edu.ventas.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.ventas.repository.IFacturaRepository;
import com.uce.edu.ventas.repository.modelo.Cliente;
import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.dto.FacturaDTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	private IFacturaRepository iFacturaRepository;
	
	@Autowired
	private IClienteService iClienteService;
	
	@Override
	public Factura buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarPorNumero(numero);
	}

	@Override
	@Transactional(value=TxType.REQUIRED)//T1
	public void guardar(Factura factura, Cliente cliente) {
		// TODO Auto-generated method stub
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		this.iFacturaRepository.insertar(factura);
		System.out.println("paso el insert de factura");
		this.iClienteService.guardar(cliente);
		System.out.println("paso el insert de cliente");

	}
	
	//

	@Override
	public List<Factura> buscarFacturasInnerJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturasInnerJoin();
	}

	@Override
	public List<Factura> buscarFacturasRigthJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturasRightJoin();
	}

	@Override
	public List<Factura> buscarFacturasLeftJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturasLeftJoin();
	}

	@Override
	public List<Factura> buscarFacturasFullJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturasFullJoin();
	}

	@Override
	public List<Factura> buscarFacturaWhereJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturaWhereJoin();
	}

	@Override
	public List<Factura> buscarFacturaFetchJoin() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturaFetchJoin();
	}

	@Override
	public int actualizarFechas(LocalDateTime fechaNueva, LocalDateTime fechaActual) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.actualizarFechas(fechaNueva, fechaActual);
	}

	@Override
	public int borrarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.eliminarPorNumero(numero);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.iFacturaRepository.eliminar(id);
	}

	@Override
	public List<FacturaDTO> buscarFacturasDTO() {
		// TODO Auto-generated method stub
		return this.iFacturaRepository.seleccionarFacturasDTO();
	}

	@Override
	@Transactional(value= TxType.MANDATORY)//obliga a que desde donde se lo llama tenga una transaccion
	public void prueba() {
		// TODO Auto-generated method stub
		System.out.println("este metodo es de prueba");
		System.out.println("prueba: "+ TransactionSynchronizationManager.isActualTransactionActive());

	}

	@Override
	public void pruebaSupports() {
		// TODO Auto-generated method stub
		System.out.println("prueba factura: " + TransactionSynchronizationManager.isActualTransactionActive());
		this.iClienteService.pruebaSupports();
	}
	
	
	@Transactional(value=TxType.REQUIRED)
	public void pruebaSupports2() {
		// TODO Auto-generated method stub
		System.out.println("prueba factura: " + TransactionSynchronizationManager.isActualTransactionActive());
		this.iClienteService.pruebaSupports();
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void pruebaNever() {
		// TODO Auto-generated method stub
		System.out.println("prueba factura: " + TransactionSynchronizationManager.isActualTransactionActive());
		this.iClienteService.pruebaNever();
	}
	
	

}
