package baralo.genericos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Inicio {

	public static void main(String[] args) {
		List<Persona> personas= new ArrayList<>();
		Persona a1 = new Alumno("David",3);
		Persona p1 = new Profesor("Manuel",1);
		Persona p3 = new Profesor("Ana",5);
		Persona p4 = new Profesor("Ana",2);
		
		personas.add(p1);

		personas.add(a1);
		personas.add(p3);
		personas.add(p4);
		personas.sort(new Comparator<Persona>() {

			@Override
			public int compare(Persona o1, Persona o2) {
				return o1.getNombre().compareTo(o2.getNombre());
				
			}
		});
		pintaPersonas(personas);
		
		System.out.println();
		
		Set<Persona> hashPersonas= new HashSet<>();//Lista con elementos unicos no ordenados
		hashPersonas.add(p1);
		hashPersonas.add(a1);
		hashPersonas.add(p3);
		hashPersonas.add(p4);
		pintaPersonas(hashPersonas);
		System.out.println();
		Set<Persona> treePersonas= new TreeSet<>();//Lista con elementos unicos ordenados
		treePersonas.add(p1);
		treePersonas.add(a1);
		treePersonas.add(p3);
		treePersonas.add(p4);
		pintaPersonas(treePersonas);
		System.out.println();
		Map<Persona, String> mapPersonas= new TreeMap<>();//Lista con elementos unicos ordenados
		mapPersonas.put(p1,p1.getNombre());
		mapPersonas.put(a1,a1.getNombre());
		mapPersonas.put(p3,p3.getNombre());
		mapPersonas.put(p4,p4.getNombre());
		pintaPersonas(mapPersonas);
	}

	public static void pintaPersonas(List<? extends Persona> personas) {
		for (Persona p : personas) {
			System.out.println(p.toString());
		}
	}
	
	public static void pintaPersonas(Set<? extends Persona> personas) {
		for (Persona p : personas) {
			System.out.println(p.toString());
		}
	}
	public static void pintaPersonas(Map<Persona,String> personas) {
		for (Entry<Persona, String> p : personas.entrySet()) {
			System.out.println(p.toString());
		}
	}
}
