package com.uce.edu.ventas.repository;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Libro2;

public interface ILibroRepository {
	
	public List <Libro2> seleccionarLibroInnerJoin();
	
	public List <Libro2> seleccionarLibroRigthJoin();

	public List <Libro2> seleccionarLibroLeftJoin();

	public List <Libro2> seleccionarLibroFullJoin();
	
	public List <Libro2> seleccionarLibroFetchJoin();


}
