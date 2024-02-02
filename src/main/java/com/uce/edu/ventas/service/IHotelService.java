package com.uce.edu.ventas.service;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Hotel;
import com.uce.edu.ventas.repository.modelo.Libro2;

public interface IHotelService {
	
	public List<Hotel> buscarHabitacionesInnerJoin(String clase);

	public List<Hotel> buscarHabitacionesRightJoin(String clase);

	public List<Hotel> buscarHabitacionesLeftJoin(String clase);

	public List<Hotel> buscarHabitacionesFullJoin(String clase);
	
	public List <Hotel> buscarHotelFetchJoin();


}
