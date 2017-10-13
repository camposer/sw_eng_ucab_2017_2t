package persona.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import persona.model.Persona;

public class PersonaDao extends BaseDao {
	
	public PersonaDao() throws SQLException {
		conectar();
	}
	
	public List<Persona> getPersonas() throws SQLException {
		String sql = "SELECT * FROM persona"; 
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		List<Persona> personas = new ArrayList<>();
		while(rs.next()) {
			// TODO Cambiar por un builder
			Persona p = new Persona(
					rs.getLong("id"),
					rs.getString("nombre"),
					rs.getString("apellido"),
					rs.getInt("edad"));
			personas.add(p);
		}
		
		return personas;
	}
	
	@Override
	protected void finalize() throws Throwable {
		desconectar();
	}

	public void insertPersona(Persona persona) throws SQLException {
		// TODO Cambiar por PreparedStatement
		String sql = "INSERT INTO persona(nombre, apellido, edad) "
				+ "VALUES ('" + persona.getNombre() + "', '" 
				+ persona.getApellido() + "', "
				+ persona.getEdad() + ")";
		Statement stmt = con.createStatement();
		stmt.execute(sql);
	}

}
