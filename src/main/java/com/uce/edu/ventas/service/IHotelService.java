package com.uce.edu.ventas.service;

import java.util.List;

import com.uce.edu.ventas.repository.modelo.Hotel;

public interface IHotelService {
	
	public List<Hotel> buscarHabitacionesInnerJoin(String clase);

	public List<Hotel> buscarHabitacionesRightJoin(String clase);

	public List<Hotel> buscarHabitacionesLeftJoin(String clase);

	public List<Hotel> buscarHabitacionesFullJoin(String clase);

}
