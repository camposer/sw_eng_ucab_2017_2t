package persona.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import persona.dao.DaoFactory;
import persona.dao.PersonaDao;

import persona.model.Persona;

@RestController
public class PersonaController {
    @Autowired
    @Qualifier("personaDaoFactory")
    private DaoFactory personaDaoFactory;
    
    /**
     * GET http://localhost:8080/personas
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", 
            value = "/personas")
    public List<Persona> getPersonas() throws SQLException {
        PersonaDao personaDao = (PersonaDao) personaDaoFactory.createDao();
        return personaDao.getPersonas();
    }
    
    /**
     * POST http://localhost:8080/personas
     * HEADER: 
     * - Content-Type: application/json
     * BODY:
     * {
     *   "nombre": "H",
     *   "apellido": "H",
     *   "edad": 20
     * }
     */
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json",
            value = "/personas")
    public ResponseEntity createPersona(@RequestBody Persona persona) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        try {
            PersonaDao personaDao = (PersonaDao) personaDaoFactory.createDao();
            personaDao.insertPersona(persona);
            status = HttpStatus.OK;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return new ResponseEntity<>(status);
    }
    
}
