package it.apuliadigital.esercizio05anagraficaserver;

import it.apuliadigital.esercizio05anagraficaserver.client.anagrafica.api.PersonaApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Esercizio05AnagraficaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Esercizio05AnagraficaServerApplication.class, args);
    }

    @Bean
    public PersonaApi apiClient() {
        PersonaApi apiClient = new PersonaApi();

        apiClient.getApiClient().setBasePath("http://localhost:8081");

        return apiClient;
    }

}
