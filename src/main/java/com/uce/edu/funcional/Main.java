package com.uce.edu.funcional;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 1.Supplier
		// clases
		System.out.println("Supplier");
		System.out.println("clases");
		IPersonaSupplier<String> supplierClase = new PersonaSupplierImpl();
		supplierClase.getId();
		System.out.println(supplierClase.getId());

		// Lambdas
		
		System.out.println("lambdas");
		IPersonaSupplier<String> supplierLambda = () -> {
			String cedula = "192392231";
			cedula = cedula + "canton";
			return cedula;
		};
		System.out.println(supplierLambda.getId());
		
		System.out.println("lambdas");
		IPersonaSupplier<String> supplierLmabda2 = () -> "465465465" +"pais";
		System.out.println(supplierLmabda2.getId());
		
		IPersonaSupplier<Integer> supplierLmabda3 = () -> {
			Integer valor1 = Integer.valueOf(100);
			valor1 = valor1 * Integer.valueOf(50) / Integer.valueOf(5);
			return valor1;
		};
		System.out.println(supplierLmabda3.getId());
		
		//METODOS REFERENCIAS
		System.out.println("Metodos Referenciados");
		MetodoReferenciados met = new MetodoReferenciados();
			IPersonaSupplier<String> supplierLambda4 = met:: obtenerId;
		System.out.println(supplierLambda4.getId());
		//2.Consumer
		System.out.println("C O N S U M E R");
		//Clases
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Profesor");
		
		System.out.println("lambdas");
		IPersonaConsumer<String> consumerLambda = (cadena)-> {
			System.out.println("se inserta");
			System.out.println(cadena);
		};
		consumerLambda.accept("Profesor");
		
		//METODOS REFERENCIAS
				System.out.println("Metodos Referenciados");
		IPersonaConsumer<String> consumer2 = met:: procesar;
		consumer2.accept("JHON referenciado");
		
		//3.PREDICATE
		System.out.println("P R E D I C A T E");
		System.out.println("lambdas");
		IPersonaPredicate<Integer> predicateLambda = (numero)-> numero.compareTo(7)==0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(7)));

		IPersonaPredicate<String> predicateLambda2 = letra -> "Erick".contains(letra);
		System.out.println(predicateLambda2.evaluar("E"));
		
		//METODOS REFERENCIAS
		System.out.println("Metodos Referenciados");
		IPersonaPredicate<String> predicate2 = met:: evaluar;
		System.out.println(predicate2.evaluar("E"));
		
		IPersonaPredicate<Integer> predicate3 = met::evaluar;
		System.out.println(predicate3.evaluar(8));
		
		
		//4. FUNCTION
		System.out.println("F U N C T I O N");
		//lambdas
		System.out.println("lambdas");
		IPersonaFuction<String, Integer> functionLambda = numero -> {
			numero = numero + Integer.valueOf(10);
			String numeroString = numero.toString().concat("-Valor");
			return numeroString;
		};
		System.out.println(functionLambda.aplicar(7));
		
		IPersonaFuction<Empleado, Ciudadano> funcionLambda2 = ciudadano ->{
			Empleado empl = new Empleado();
			empl.setNombreCompleto(ciudadano.getNombre() + " " + ciudadano.getApellido());
			if(ciudadano.getProvincia().compareTo("pichincha")==0) {
				empl.setPais("Ecuador");
			}
			return empl;
		};
		Ciudadano ciud = new Ciudadano();
		ciud.setApellido("Enriquez");
		ciud.setNombre("Erick");
		ciud.setProvincia("pichincha");
		
		Empleado empl= funcionLambda2.aplicar(ciud);
		System.out.println(empl);
		
		//METODOS REFERENCIAS
				System.out.println("Metodos Referenciados");
		
				Empleado empl2 = new Empleado();
				empl2.setNombreCompleto("Daniel Tobogan");
				empl2.setPais("Ecuadoorrr");
				IPersonaFuction<Ciudadano, Empleado> function2 = met::cambiar;
		Ciudadano ciud2 = function2.aplicar(empl2);
				System.out.println(ciud2);
				
		//5. unary operator
		System.out.println("unitary Operator");
		System.out.println("Lambdas");
		IPersonaUnayOpeator<Integer> unaryOperatorLmabda = numero ->numero + (numero*2);
		System.out.println(unaryOperatorLmabda.aplicar(14));
		
		IPersonaUnaryOperatorFunction<Integer> unaryOperatorLambda2 = numero -> numero + (numero*2);
		System.out.println(unaryOperatorLambda2.aplicar(10));
	
		//metodo referneicados asod aqofjq
		System.out.println("Metodos Referenciados");
		IPersonaUnaryOperatorFunction<Empleado> unary3 = met ::procesar;
		Empleado empl3 = unary3.aplicar(empl2);
		System.out.println(empl3);
		
	}
	
	
	
	

}
