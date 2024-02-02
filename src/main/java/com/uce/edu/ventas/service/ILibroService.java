package com.uce.edu.ventas.service;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Libro2;

public interface ILibroService {

	public List <Libro2> buscarLibroInnerJoin();
	
	public List <Libro2> buscarLibroRigthJoin();

	public List <Libro2> buscarLibroLeftJoin();

	public List <Libro2> buscarLibroFullJoin();
	
	public List <Libro2> buscarLibroFetchJoin();


	
}
