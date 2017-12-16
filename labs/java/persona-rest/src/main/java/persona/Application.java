package persona;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import persona.dao.Dao;
import persona.dao.DaoFactory;
import persona.dao.DataSourceFactory;
import persona.dao.PersonaDao;

@SpringBootApplication
public class Application {
    
    @Configuration
    static class Config {
        @Bean
        public DataSource dataSource() {
            return DataSourceFactory.createMySqlDataSource();
        }
        
        @Bean
        @Scope(value = "prototype")
        public PersonaDao personaDao() throws SQLException {
            return new PersonaDao(dataSource().getConnection());
        }
        
        @Bean
        public DaoFactory personaDaoFactory() {
            return () -> personaDao();
        }
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
