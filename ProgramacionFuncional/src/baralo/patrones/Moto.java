package baralo.patrones;

public class Moto extends Vehiculo {

	@Override
	public String acelerar() {
		return "La moto esta acelerando";
	}
	@Override
	public void pintaVehiculo() {
		System.out.println("Soy una moto ");
		
		
	}
}
