package com.uce.edu.ventas.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.ventas.repository.modelo.Factura;
import com.uce.edu.ventas.repository.modelo.Libro2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LibroRepositoryImpl implements ILibroRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Libro2> seleccionarLibroInnerJoin() {

		// jpql:SELECT f FROM Factura f JOIN f.detalleFactura d
		TypedQuery<Libro2> myQuery = this.entityManager
				.createQuery("SELECT l Libro2 FROM Libro2 l JOIN l.autoresLibros a", Libro2.class);
		List<Libro2> lista = myQuery.getResultList();
		for (Libro2 f : lista) {
			f.getAutoresLibros().size();
		}
		return lista;
	}

	@Override
	public List<Libro2> seleccionarLibroRigthJoin() {
		// jpql:SELECT f FROM Factura f JOIN f.detalleFactura d
		TypedQuery<Libro2> myQuery = this.entityManager
				.createQuery("SELECT l Libro2 FROM Libro2 l RIGHT JOIN l.autoresLibros a", Libro2.class);
		List<Libro2> lista = myQuery.getResultList();
		for (Libro2 f : lista) {
			f.getAutoresLibros().size();
		}
		return lista;
	}

	@Override
	public List<Libro2> seleccionarLibroLeftJoin() {
		// jpql:SELECT f FROM Factura f JOIN f.detalleFactura d
		TypedQuery<Libro2> myQuery = this.entityManager
				.createQuery("SELECT l Libro2 FROM Libro2 l LEFT JOIN l.autoresLibros a", Libro2.class);
		List<Libro2> lista = myQuery.getResultList();
		for (Libro2 f : lista) {
			f.getAutoresLibros().size();
		}
		return lista;
	}

	@Override
	public List<Libro2> seleccionarLibroFullJoin() {
		// jpql:SELECT f FROM Factura f JOIN f.detalleFactura d
		TypedQuery<Libro2> myQuery = this.entityManager
				.createQuery("SELECT l Libro2 FROM Libro2 l FULL JOIN l.autoresLibros a", Libro2.class);
		List<Libro2> lista = myQuery.getResultList();
		for (Libro2 f : lista) {
			f.getAutoresLibros().size();
		}
		return lista;
	}

	@Override
	public List<Libro2> seleccionarLibroFetchJoin() {
		// TODO Auto-generated method stub
		//SELECT l Libro2 FROM Libro2 l FULL JOIN l.autoresLibros a
		TypedQuery<Libro2> myQuery = this.entityManager.createQuery("SELECT l Libro2 FROM Libro2 l JOIN FETCH l.autoresLibros a", Libro2.class);

		return myQuery.getResultList();
	}

}
