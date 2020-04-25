package baralo.lambda;

import java.util.ArrayList;
import java.util.List;

import baralo.genericos.Alumno;
import baralo.genericos.Persona;
import io.reactivex.Observable;

public class RxJava {

	List<Persona> personas = new ArrayList<>();
	public static void main(String[] args) {
	
		RxJava app = new RxJava();
		app.llenarLista();
		app.buscar();
		
System.out.println("Fin");
	}
	
	public void llenarLista() {

			personas.add(new Alumno("David",1));
			personas.add(new Alumno("Diego",2));
			personas.add(new Alumno("Felix",3));
			personas.add(new Alumno("Juan",6));
			personas.add(new Alumno("Pablo",7));
			personas.add(new Alumno("Ana",4));
			
		
	}
	
	
		

	public void buscar() {
		Observable<Persona> observable = Observable.fromIterable(personas);
	
		observable.filter(p -> p.getEdad() % 2 == 0)
					.map(nombre -> nombre.getNombre())
					.subscribe(System.out::println);
		
		
		
	
	}
	
	public void pintar() {
		personas.forEach(System.out::println);
	}

}
