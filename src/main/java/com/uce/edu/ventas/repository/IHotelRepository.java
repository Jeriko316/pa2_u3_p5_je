package com.uce.edu.ventas.repository;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Hotel;

public interface IHotelRepository {

	//DEBER PONER ARGUMENTO A LOS METODOS JOINS
		//public void insertar(Hotel hotel);
		
		public List<Hotel> seleccionarHabitacionesInnerJoin(String clase);

		public List<Hotel> seleccionarHabitacionesRightJoin(String clase);

		public List<Hotel> seleccionarHabitacionesLeftJoin(String clase);

		public List<Hotel> seleccionarHabitacionesFullJoin(String clase);
	
}
