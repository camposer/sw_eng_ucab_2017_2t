package persona.gui;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import persona.dao.PersonaDao;
import persona.model.Persona;

public class PersonaGui {
	private Scanner scanner;
	// TODO Incluir capa de lógica de negocio
	private PersonaDao personaDao;
	
	public PersonaGui() {
		scanner = new Scanner(System.in);
		try {
			personaDao = new PersonaDao();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al conectar "
					+ "con la BD");
			System.err.println(e); // TODO Cambiar por un logger (log4j)
		}
	}
	
	public void iniciar() {
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
			else if (opcion.equals("2"))
				insertar();
//			else if (opcion.equals("3"))
//				actualizar();
//			else if (opcion.equals("4"))
//				eliminar();
			else if (opcion.equals("5"))
				salir = true;
		}
	}

	private void insertar() {
		System.out.print("Nombre? ");
		String nombre = scanner.nextLine();
		System.out.print("Apellido? ");
		String apellido = scanner.nextLine();
		System.out.print("Edad? ");
		String sedad = scanner.nextLine();
		Integer edad = 0;
		
		try {
			edad = Integer.parseInt(sedad);
		} catch(Exception e) {
			System.out.println("Edad inválida, utilizando 0");
			System.err.println(e); // TODO Cambiar por un logger
		}
		
		// TODO Cambiar construcción de persona por un builder
		try {
			personaDao.insertPersona(new Persona(nombre,
					apellido, edad));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void listar() {
		try {
			List<Persona> personas = personaDao.getPersonas();
			for (Persona p : personas) {
				System.out.println(p);
			}
			System.out.println();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al consultar "
					+ "las personas en la BD");
			System.err.println(e); // TODO Cambiar por un logger
		}
	}
}
