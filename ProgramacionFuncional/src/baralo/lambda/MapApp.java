package baralo.lambda;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import baralo.genericos.Alumno;
import baralo.genericos.IPersona;
import baralo.genericos.Persona;

public class MapApp {
	
	private void filtrar(Collection<Persona> personas, Consumer<Persona> consumidor, String textoBusqueda) {
		personas.stream().filter(predicadoBusqueda(textoBusqueda)).forEach(consumidor);
	}
	
	private Predicate<Persona> predicadoBusqueda(String textoBusqueda){
		return p -> p.getNombre().contains(textoBusqueda);
	}
	public static void main(String[] args) {
		Map<Integer,Persona> map = new HashMap<>();
		IPersona p = Alumno::new;
		map.put(1, p.crearPersona("David", 10));
		map.put(2, p.crearPersona("Juan", 9));
		map.put(3, p.crearPersona("Diego", 1));
		
		Map<Integer,Persona> submap = 
				map.entrySet().stream()
				.filter(per -> per.getValue().getNombre().contains("D"))
				.collect(Collectors.toMap(e -> e.getKey(),e -> e.getValue()));
		
		submap.forEach((k,v)->System.out.println(v.toString()));
		MapApp app = new MapApp();
		app.filtrar(map.values(),System.out::println,"D");
	}

}
