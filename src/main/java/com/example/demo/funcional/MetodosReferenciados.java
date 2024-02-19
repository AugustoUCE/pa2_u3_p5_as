package com.example.demo.funcional;

public class MetodosReferenciados {
	
	public String obtenerId() {
		
		String cedula ="1752083905";
		cedula=cedula+"referenciados";
		return cedula;
	}
	
	public void procesar(String cadena) {
		System.out.println(cadena);
		System.out.println("se procesa la cadena");
	}
	
	public boolean evaluar(String cadena) {
		
		return "JHON".toLowerCase().contains(cadena);
	}
	
	
	public boolean evaluar(Integer numero) {
		return 8==numero;
	}
	
	public Ciudadano cambiar(Empleado emp) {
		Ciudadano ciu = new Ciudadano();
		String nombre= emp.getNombreCompleto().split("")[0];
		String apellido=emp.getNombreCompleto().split("")[1];
		ciu.setNombre(nombre);
		ciu.setApellido(apellido);
		ciu.setProvincia("tulcan");
		return ciu;
	}
	
	public Empleado procesar(Empleado empl) {
		empl.setNombreCompleto(empl.getNombreCompleto()+""+empl.getPais());
		empl.setPais(empl.getPais()+""+"`de nacimiento");
		return empl;
		
	}

}
