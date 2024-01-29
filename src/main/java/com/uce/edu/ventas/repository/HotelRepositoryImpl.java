package com.uce.edu.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.Habitacion;
import com.uce.edu.ventas.repository.modelo.Hotel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HotelRepositoryImpl implements IHotelRepository {

	 @PersistenceContext
	 private EntityManager entityManager;
	


	@Override
	public List<Hotel> seleccionarHabitacionesInnerJoin(String clase) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h JOIN h.habitaciones d WHERE h.tipo = :tipo", Hotel.class);
		myQuery.setParameter("tipo", clase);
		List<Hotel> lista = myQuery.getResultList();
		for(Hotel f:lista) {
			f.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHabitacionesRightJoin(String tipo) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h RIGHT JOIN h.habitaciones d WHERE h.nombre = :tipo", Hotel.class);
		myQuery.setParameter("tipo", tipo);
		List<Hotel> lista = myQuery.getResultList();
		for(Hotel f:lista) {
			f.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHabitacionesLeftJoin(String tipo) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h LEFT JOIN h.habitaciones d WHERE h.tipo = :tipo", Hotel.class);
		myQuery.setParameter("tipo", tipo);
		List<Hotel> lista = myQuery.getResultList();
		for(Hotel f:lista) {
			f.getHabitaciones().size();
		}
		return lista;
	}

	@Override
	public List<Hotel> seleccionarHabitacionesFullJoin(String tipo) {
		// TODO Auto-generated method stub
		TypedQuery<Hotel> myQuery = this.entityManager.createQuery("SELECT h FROM Hotel h FULL JOIN h.habitaciones d WHERE d.clase = :tipo", Hotel.class);
		myQuery.setParameter("tipo", tipo);
		List<Hotel> lista = myQuery.getResultList();
		for(Hotel f:lista) {
			f.getHabitaciones().size();
		}
		return lista;
	}

}
