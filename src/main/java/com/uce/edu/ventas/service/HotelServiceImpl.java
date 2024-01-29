package com.uce.edu.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.ventas.repository.IHotelRepository;
import com.uce.edu.ventas.repository.modelo.Hotel;

@Service
public class HotelServiceImpl implements IHotelService{

	@Autowired
	private IHotelRepository hotelRepository;
	
	@Override
	public List<Hotel> buscarHabitacionesInnerJoin(String tipo) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHabitacionesInnerJoin(tipo);
	}

	@Override
	public List<Hotel> buscarHabitacionesRightJoin(String tipo) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHabitacionesRightJoin(tipo);
	}

	@Override
	public List<Hotel> buscarHabitacionesLeftJoin(String tipo) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHabitacionesLeftJoin(tipo);
	}

	@Override
	public List<Hotel> buscarHabitacionesFullJoin(String tipo) {
		// TODO Auto-generated method stub
		return this.hotelRepository.seleccionarHabitacionesFullJoin(tipo);
	}

	
}
