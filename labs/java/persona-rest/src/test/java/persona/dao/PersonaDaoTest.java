package persona.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import persona.model.Persona;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonaDaoTest {
    
    @Autowired
    private Connection con;
    @Autowired
    private PersonaDao personaDao;
    
    @Configuration
    static class Config {
        @Bean
        public Connection connection() throws SQLException {
            return DataSourceFactory.createH2Connection().getConnection();
        }
        
        @Bean
        public PersonaDao personaDao(Connection connection) {
            return new PersonaDao(connection);
        }    
    }
    
    @Before
    public void setup() throws SQLException {
        Statement stmt = con.createStatement();
        stmt.execute("" +
        "CREATE TABLE persona (" +
        "	id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY," +
        "	nombre VARCHAR(50) NOT NULL," +
        "	apellido VARCHAR(50) NOT NULL," +
        "	edad INT NULL" +
        ")");
    }
    
    @After
    public void tearDown() throws SQLException {
        Statement stmt = con.createStatement();
        stmt.execute("DROP TABLE persona");        
    }
    
    @Test
    public void insertPersona_success() throws SQLException {
        int cantidadPersonas = personaDao.getPersonas().size();
        Persona persona = new Persona("nombre", "apellido", 20);
        personaDao.insertPersona(persona);
        
        Assert.assertEquals(cantidadPersonas + 1, 
                personaDao.getPersonas().size());
    }
}
