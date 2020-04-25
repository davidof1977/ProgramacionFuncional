package com.davidof.functional;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Consumers {
	
	public static void main(String[] args) {
		
		pintarNombre.accept("David");
		pintarNombreApellido.accept("David","Bartolome");
	}

	static Consumer<String> pintarNombre = nombre-> System.out.print(nombre);
	static BiConsumer<String, String> pintarNombreApellido = (nombre, apellido) ->  System.out.print(nombre + " - " + apellido);
	
}
