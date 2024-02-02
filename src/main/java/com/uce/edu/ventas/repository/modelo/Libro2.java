package com.uce.edu.ventas.repository.modelo;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="libro2")
public class Libro2 {

	@Id
	@Column(name="libr_id")
	@SequenceGenerator(name = "seq_libro2", sequenceName = "seq_libro2", allocationSize=1)  //crear la secuencia
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_libro2")
	private Integer id;
	
	@Column(name="libr_titulo")
	private String titulo;
	
	@Column(name="libr_fecha_publicacion")
	private LocalDateTime FechaPublicacion;


	@OneToMany(mappedBy="libro2", cascade=CascadeType.ALL)
	
	private List <AutorLibro> autoresLibros; //lista para uno a muchos

	
	
	
	
	
	//steer and getters 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDateTime getFechaPublicacion() {
		return FechaPublicacion;
	}

	public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
		FechaPublicacion = fechaPublicacion;
	}

	public void setAutoresLibros(List<AutorLibro> autoresLibros) {
		this.autoresLibros = autoresLibros;
	}
	
	public List<AutorLibro> getAutoresLibros() {
		return autoresLibros;
	}

	@Override
	public String toString() {
		return "Libro2 [id=" + id + ", titulo=" + titulo + ", FechaPublicacion=" + FechaPublicacion + "]";
	}
	
	
}
