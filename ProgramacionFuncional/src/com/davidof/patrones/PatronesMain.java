package com.davidof.patrones;

import java.awt.print.Printable;

public class PatronesMain {

	public static void main(String[] args) {
		
		try {
			Coche c = (Coche)FactoryVehiculo.getVehoculo("Coche");
			c.getAsientos().add(new Asiento("Rojo"));
			c.getAsientos().add(new Asiento("Azul"));
			
			Coche c2 = (Coche)c.clone();
			c2.getAsientos().get(0).setColor("Negro");
			c.pintaVehiculo();
			
			c2.pintaVehiculo();
			
			
			
			PintaCocheRojoDecorador decorador = new PintaCocheRojoDecorador(c);
			decorador.pintaVehiculo();

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
