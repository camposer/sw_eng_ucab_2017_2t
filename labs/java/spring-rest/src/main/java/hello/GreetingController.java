package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @Autowired // inyecta la dependencia (definida en Application.java)
    private Converter converter;

    // contador atómico
    private final AtomicLong counter = new AtomicLong();

    // GET http://localhost:8080/greeting
    // GET http://localhost:8080/greeting?name=Joe
    @RequestMapping(method = RequestMethod.GET, value = "/greeting", produces = MediaType.APPLICATION_JSON_VALUE)
    public Greeting greetingGetQueryString(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), converter.convert(name));
    }

    // GET http://localhost:8080/greeting/Joe
    @RequestMapping(method = RequestMethod.GET, value = "/greeting/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Greeting greetingGetPathVariable(@PathVariable(value="name") String name) {
        return new Greeting(counter.incrementAndGet(), converter.convert(name));
    }

    // POST http://localhost:8080/greeting
    // Headers:
    // - Content-Type: application/json
    // Body:
    // {
    //   "name": "Joe"
    // }
    @RequestMapping(method = RequestMethod.POST, value = "/greeting", consumes = MediaType.APPLICATION_JSON_VALUE, 
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Greeting greetingPost(@RequestBody GreetingBody greetingBody) {
        return new Greeting(counter.incrementAndGet(), converter.convert(greetingBody.getName()));
    }
}
