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
        AlbumApi apiClient = new AlbumApi();

        apiClient.getApiClient().setBasePath("http://localhost:8082");

        return apiClient;
    }

    @Bean
    public SearchApi searchApiClient() {
        SearchApi searchApiClient = new SearchApi();

        searchApiClient.getApiClient().setBasePath("http://localhost:8082");

        return searchApiClient;
    }

    @Bean
    public ArtistApi artistApiClient() {
        ArtistApi artistApiClient = new ArtistApi();

        artistApiClient.getApiClient().setBasePath("http://localhost:8081");

        return artistApiClient;
    }
}
