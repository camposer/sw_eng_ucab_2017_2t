package persona.dao;

import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;

public class DataSourceFactory {

    public static DataSource createMySqlDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost/persona_rest?serverTimezone=UTC")
                .username("admin")
                .password("admin")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
    
    public static DataSource createH2Connection() {
        return DataSourceBuilder.create()
                .url("jdbc:h2:~/test")
                .username("")
                .password("")
                .driverClassName("org.h2.Driver")
                .build();
    }
    

}
