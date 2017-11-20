package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class Application {
    
    @Configuration
    static class Config { // contiene la definición de los beans que forman parte del contexto de aplicaciones de Spring
        // TODO agregar beans de servicios y dao
        
        @Bean
        public Converter converter() {
            return new Converter();
        }
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
