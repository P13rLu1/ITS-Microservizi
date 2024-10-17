package it.apuliadigital.esercizio07examplejarfordocker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Esercizio07ExampleJarForDockerApplication {

    Logger logger = LoggerFactory.getLogger(Esercizio07ExampleJarForDockerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(Esercizio07ExampleJarForDockerApplication.class, args);
    }

    @GetMapping("/hello")
    public String sayHello() {
        logger.debug("Sei nel LOG");
        return "Risposta";
    }
}
