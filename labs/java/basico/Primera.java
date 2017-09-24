package basico;

public class Primera {
	public static void main(String[] args) {
		Persona p = new Persona();
		p.nombre = "nombre";
		// p.peso = 80.4f; // fala
		p.altura = 1.80f;
		System.out.println(p);
		
		Estudiante e = new Estudiante();
		e.nombre = "estudiante";
		e.altura = 1.6f;
		e.carrera = "Informática";
		e.anioEnCurso = "5to";
		e.edad = 30;
		System.out.println(e);
		
		Persona p1 = e;
		System.out.println(p1); // ?
		Estudiante e1 = (Estudiante)p1; // casting
		System.out.println(e1); // ?
	}
}

/**
 * Esta clase define una persona
 * 
 * @author Rodolfo
 *
 */
class Persona extends Object {
	public String nombre; // todos
	private float peso; // sólo yo
	protected int edad;
	float altura; // todos los que están en el mismo paquete
	
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + 
				", peso=" + peso + ", altura=" + altura + "]";
	}

	/**
	 * Este método sirve para ....
	 * @param anioInicio Identifica el año deniioic.-..
	 * @return El año que ....
	 */
	public int calcularEdad(int anioInicio) {
		return 0; // TODO Implementar
	}
	
	int calcularEdad(String anioInicio, int a) { // Overload
		return 0; // TODO Implementar
	}
	
	public float calcularEdad(int a, String anioInicio12) {
		return 0; // TODO Implementar
	}
}

class Estudiante extends Persona {
	public String carrera;
	public String anioEnCurso;
	@Override
	public String toString() {
		return "Estudiante [carrera=" + carrera + 
				", anioEnCurso=" + anioEnCurso + 
				", nombre=" + nombre + ", edad="
				+ edad + ", altura=" + altura + "]";
	}

	
}
