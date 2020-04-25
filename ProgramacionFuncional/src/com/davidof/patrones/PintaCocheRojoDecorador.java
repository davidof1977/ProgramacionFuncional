package com.davidof.patrones;

public class PintaCocheRojoDecorador extends PintaVehiculoDecorador {

	public PintaCocheRojoDecorador(IPinta pintaCoche) {
		super(pintaCoche);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pintaVehiculo() {
		this.pintaVehiculoDecorador.pintaVehiculo();
		System.out.println("Pinto el coche de rojo");
		
	}
	


}
