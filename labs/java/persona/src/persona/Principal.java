package persona;

import java.util.List;
import java.util.Scanner;

import persona.dao.PersonaDao;
import persona.models.Persona;

public class Principal {
	private Scanner scanner;
	// TODO Incluir capa de lógica de negocio
	private PersonaDao personaDao;
	
	public static void main(String[] args) {
		new Principal().iniciar();
	}
	
	public Principal() {
		scanner = new Scanner(System.in);
		personaDao = new PersonaDao();
	}
	
	private void iniciar() {
		boolean salir = false;
		while (!salir) {
			System.out.println("1. Listar");
			System.out.println("2. Insertar");
			System.out.println("3. Actualizar");
			System.out.println("4. Eliminar");
			System.out.println("5. Salir");
			System.out.print("? ");
			String opcion  = scanner.nextLine();
			
			if (opcion.equals("1")) 
				listar();
//			else if (opcion.equals("2"))
//				insertar();
//			else if (opcion.equals("3"))
//				actualizar();
//			else if (opcion.equals("4"))
//				eliminar();
			else if (opcion.equals("5"))
				salir = true;
		}
	}

	private void listar() {
		List<Persona> personas = personaDao.getPersonas();
		for (Persona p : personas) {
			System.out.println(p);
		}
		System.out.println();
	}
}
