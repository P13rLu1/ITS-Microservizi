package it.apuliadigital.esercizio02portaleapi;

import it.apuliadigital.esercizio02portaleapi.client.album.api.AlbumApi;
import it.apuliadigital.esercizio02portaleapi.client.album.api.SearchApi;
import it.apuliadigital.esercizio02portaleapi.client.artista.api.ArtistApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Esercizio02PortaleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(Esercizio02PortaleApiApplication.class, args);
    }

    @Bean
    public AlbumApi apiClient() {
        return new AlbumApi();
    }

    @Bean
    public SearchApi searchApiClient() {
        return new SearchApi();
    }

    @Bean
    public ArtistApi artistApiClient() {
        return new ArtistApi();
    }
}
