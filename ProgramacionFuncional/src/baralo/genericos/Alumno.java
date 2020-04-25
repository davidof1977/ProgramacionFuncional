package baralo.genericos;

public class Alumno extends Persona implements IPinta {

	public Alumno(String nombre, int edad) {
		super(nombre, edad);
	}
	@Override
	public void pintaNombre() {
		System.out.println("Soy el alumno " + this.getNombre());
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + this.getNombre() + ", edad=" + this.getEdad() + "]";
	}
	@Override
	public Persona crearPersona(String nombre, Integer edad) {
		// TODO Auto-generated method stub
		return new Alumno(nombre, edad)
				;
	}
}
