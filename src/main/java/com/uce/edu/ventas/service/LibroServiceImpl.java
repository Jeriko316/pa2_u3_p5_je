package com.uce.edu.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ventas.repository.ILibroRepository;
import com.uce.edu.ventas.repository.modelo.Libro2;

@Service
public class LibroServiceImpl implements ILibroService {

	@Autowired
	private ILibroRepository libroRepository;

	@Override
	public List<Libro2> buscarLibroInnerJoin() {
		// TODO Auto-generated method stub
		return this.libroRepository.seleccionarLibroInnerJoin();
	}

	@Override
	public List<Libro2> buscarLibroRigthJoin() {
		// TODO Auto-generated method stub
		return this.libroRepository.seleccionarLibroRigthJoin();
	}

	@Override
	public List<Libro2> buscarLibroLeftJoin() {
		// TODO Auto-generated method stub
		return this.libroRepository.seleccionarLibroLeftJoin();
	}

	@Override
	public List<Libro2> buscarLibroFullJoin() {
		// TODO Auto-generated method stub
		return this.libroRepository.seleccionarLibroFullJoin();
	}

	@Override
	public List<Libro2> buscarLibroFetchJoin() {
		// TODO Auto-generated method stub
		return this.libroRepository.seleccionarLibroFetchJoin();
	}
	
	
	
}
