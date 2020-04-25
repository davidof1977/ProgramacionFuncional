package baralo.patrones;

public abstract class PintaVehiculoDecorador implements IPinta{

	protected IPinta pintaVehiculoDecorador;

	public PintaVehiculoDecorador(IPinta pintaVehiculoDecorador) {
		super();
		this.pintaVehiculoDecorador = pintaVehiculoDecorador;
	}
	
	
}
