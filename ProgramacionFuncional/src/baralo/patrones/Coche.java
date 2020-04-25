package baralo.patrones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Coche extends Vehiculo implements Cloneable {

	@Override
	public String acelerar() {
		return "El coche esta acelerando";
	}
	
	private List<Asiento> asientos;
	
	public List<Asiento> getAsientos() {
		if(asientos==null)
			asientos = new ArrayList<>();
		return asientos;
	}

	public void setAsientos(List<Asiento> asientos) {
		this.asientos = asientos;
	}
	
	public Object clone(){
        Coche obj=null;
        try{
            obj=(Coche)super.clone();
        }catch(Exception ex){
            System.out.println(" no se puede duplicar");
        }
	
		List<Asiento> asientoListClone = new ArrayList<>();
		Iterator<Asiento> iterator = asientos.iterator();
		 
		while(iterator.hasNext())
		{
		    //Add the object clones
		    asientoListClone.add((Asiento) iterator.next().clone());  
		}
		
		 obj.setAsientos(asientoListClone);
        return obj;
    }

	@Override
	public void pintaVehiculo() {
		System.out.println("Soy un coche con asientos de estos colores: ");
		for (Asiento asiento : asientos) {
			System.out.println(asiento.getColor());
		}
		
	}

}
