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
		
		//3.PREDICATE
		System.out.println("P R E D I C A T E");
		System.out.println("lambdas");
		IPersonaPredicate<Integer> predicateLambda = (numero)-> numero.compareTo(7)==0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(7)));

		IPersonaPredicate<String> predicateLambda2 = letra -> "Erick".contains(letra);
		System.out.println(predicateLambda2.evaluar("E"));
	}
	
	

}
