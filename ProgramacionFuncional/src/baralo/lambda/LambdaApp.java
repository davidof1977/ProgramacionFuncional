package baralo.lambda;

import java.util.ArrayList;
import java.util.List;

import baralo.genericos.Alumno;
import baralo.genericos.IPersona;
import baralo.genericos.Persona;
import baralo.genericos.Profesor;

public class LambdaApp {
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ISuma suma = (x,y)->x+y;
		Integer resultado = suma.suma(2,5);
		System.out.println(resultado);
		suma = (x,y)->{return x+y;};
		resultado = suma.suma(2,5);
		System.out.println(resultado);
		
		LambdaApp.procesar(LambdaApp::suma,5,5);
		suma = LambdaApp::suma;
		System.out.println(suma.suma(4, 2));
		
		List<Persona> personas = new ArrayList<>();
		//IPersona i = (x,y)->new Alumno(x,y);
		IPersona i = Alumno::new;
		personas.add(i.crearPersona("David",3));

		personas.add(new Alumno("Javier",2));
		personas.add(new Profesor("Daniel",5));
				
		//personas.sort((o1,o2)->o1.getEdad()-o2.getEdad());
		personas.sort(Persona::compareTo);
		personas.removeIf(p->p.getNombre().equalsIgnoreCase("Javier"));
		personas.stream().filter(p->p.getNombre().startsWith("D"))
			.map(p->p.getNombre().toUpperCase())
			.forEach(System.out::println);
		//personas.forEach(System.out::println);
		Persona g =personas.stream().filter(p->p.getNombre().startsWith("D")).findFirst().get();
		System.out.println(g);

	}
	private static void procesar(ISuma funcion, int x, int y) {
		System.out.println(funcion.suma(x, y));
	}
	
	private static int suma(int x, int y) {
		return x+y;
	}

}
