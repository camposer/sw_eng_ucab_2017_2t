package persona.dao;

import java.sql.SQLException;

public interface DaoFactory {
    Dao createDao() throws SQLException;
}
