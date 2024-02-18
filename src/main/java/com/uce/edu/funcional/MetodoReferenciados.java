package com.uce.edu.funcional;

public class MetodoReferenciados {

	public String obtenerId() {
		String cedula = "192392231";
		cedula = cedula + "provincia";
		return cedula;
	}
	
	public void procesar(String cadena) {
		System.out.println(cadena);
		System.out.println("se proceso la cadena");
	}
	
	public boolean evaluar(String cadena) {
		return "Erick".contains(cadena);
	}
	
	public boolean evaluar(Integer numero) {
		return 8 == numero;
	}
	
	public Ciudadano cambiar(Empleado empl) {
		Ciudadano ciud = new Ciudadano();
		String nombre = empl.getNombreCompleto().split(" ")[0];
		String apellido = empl.getNombreCompleto().split(" ")[1];
		ciud.setNombre(nombre);
		ciud.setApellido(apellido);
		ciud.setProvincia("chimborazo");
		return ciud;
	}
	
	public Empleado procesar(Empleado empl) {
		empl.setNombreCompleto(empl.getNombreCompleto() +  " "+ empl.getPais());
		empl.setPais(empl.getPais() + "de nacimiento" );
		return empl;
	}
}
