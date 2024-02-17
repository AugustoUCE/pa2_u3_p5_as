package com.example.demo.funcional;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//implementacion mediante clase
		//1.Supplier
		//Clases
		System.out.println("clases");
		IPersonaSupplier<String> supplierClase=new PersonaSupplierImpl();
		System.out.println(supplierClase.getId());
		
		//lambdas
		System.out.println("lambdas");

		IPersonaSupplier<String> supplierLambda = () ->{
			String cedula = "2134312";
			cedula=cedula+"canton";
			return cedula;
		};
		System.out.println(supplierLambda.getId());
		
		IPersonaSupplier<String> supplierLambda2 = () -> "2134312"+"pais";
		
		System.out.println(supplierLambda2.getId());
		
		
IPersonaSupplier<Integer> supplierLambda3 = () -> {
	Integer valor1= Integer.valueOf(100);
	valor1=valor1*Integer.valueOf(50)/ Integer.valueOf(5);
			return valor1;
};
		System.out.println(supplierLambda3.getId());
		
	//Metodos referenciados
		//2.Consumer
		System.out.println("***************************CONSUMER");
		//clases
		System.out.println("Clases");
		IPersonaConsumer<String> consumerClase=new IPersonaConsumerImpl();
		consumerClase.accept("Profesor");
		
		System.out.println("lambdas");

		IPersonaConsumer<String> consumerLambda = cadena ->{
			System.out.println("Se inserta");
			System.out.println(cadena);
		};
		consumerLambda.accept("profesor");
		
		//3. Predicate
		System.out.println("***************************PREDICATE");
		//ya no clases por que es repetitivo
		//Lambdas
		System.out.println("Lambdas");
		IPersonaPredicate<Integer> predicateLambda= numero -> numero.compareTo(7)==0;
		System.out.println(predicateLambda.evaluar(Integer.valueOf(7)));
		
		IPersonaPredicate<String> predicateLambda1=letra -> "augusto".contains(letra) ;
		System.out.println(predicateLambda1.evaluar("e"));
	}

}
