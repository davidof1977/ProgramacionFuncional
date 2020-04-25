package baralo.patrones;

public class FactoryVehiculo {

	public static Vehiculo getVehoculo(String tipo) throws Exception {
		if (tipo.equalsIgnoreCase("Coche")){
			return new Coche();
		}else if (tipo.equalsIgnoreCase("Moto")){
			return new Moto();
		}else
		throw new Exception("No existe factoria para el tipo " + tipo);
			
	}
}
