package persona.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDao {
	protected Connection con;
	private static final String URL = 
			"jdbc:mysql://localhost/prueba";
	// "jdbc:mysql://localhost/prueba;user=root;password=";
	private static final String USER = "root";
	private static final String PASSWORD = "";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected void conectar() throws SQLException {
		con = DriverManager.getConnection(URL,
				USER, PASSWORD);
	}
	
	protected void desconectar() throws SQLException {
		con.close();
	}
}
