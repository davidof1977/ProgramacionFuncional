package com.davidof.genericos;

public class Profesor extends Persona implements IPinta {

	
	public Profesor(String nombre, int edad) {
		super(nombre,edad);
	}
	@Override
	public void pintaNombre() {
		System.out.println("Soy el profesor " + this.getNombre());
	}
	@Override
	public String toString() {
		return "Profesor [nombre=" + this.getNombre() + ", edad=" + this.getEdad() + "]";
	}
	@Override
	public Persona crearPersona(String nombre, Integer edad) {
		// TODO Auto-generated method stub
		return  new Profesor(nombre, edad);
	}
	
}
