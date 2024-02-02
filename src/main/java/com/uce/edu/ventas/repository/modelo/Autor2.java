package com.uce.edu.ventas.repository.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name= "autor2")
public class Autor2 {
	
	@Id
	@Column(name = "auto_id")
	@SequenceGenerator(name = "seq_autor2", sequenceName = "seq_autor2", allocationSize=1)  //crear la secuencia
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_autor2")
	private Integer id;
	
	@Column(name="auto_nombre")
	private String nombre;
	
	@Column(name="auto_nacionalidad")
	private String nacionalidad;

	//tabla principal
	@OneToMany(mappedBy="autor2")
	private List <AutorLibro> autoresLibros;
	
	
	
	
	
	
	//getters and seters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public List<AutorLibro> getAutoresLibros() {
		return autoresLibros;
	}

	public void setAutoresLibros(List<AutorLibro> autoresLibros) {
		this.autoresLibros = autoresLibros;
	}

	


	
	
}
