package it.apuliadigital.esercizio02portaleapi.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.esercizio02portaleapi.api.PortaleApi;
import it.apuliadigital.esercizio02portaleapi.model.Album;
import it.apuliadigital.esercizio02portaleapi.model.AlbumEArtista;
import it.apuliadigital.esercizio02portaleapi.model.ArtistaEAlbums;
import it.apuliadigital.esercizio02portaleapi.service.PortaleService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;

import java.util.List;


@RestController
public class PortaleController implements PortaleApi {

    Logger logger = LoggerFactory.getLogger(PortaleController.class);

    @Autowired
    private PortaleService portaleService;

    @Override
    public ResponseEntity<AlbumEArtista> albumAndArtist(@Parameter(name = "idAlbum", description = "id dell'album da ritornare", required = true, in = ParameterIn.PATH) @PathVariable("idAlbum") Long idAlbum) {

        logger.info("Chiamata al servizio albumAndArtist con idAlbum: {}", idAlbum);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ArtistaEAlbums> artistandAlbum(@Parameter(name = "idArtista", description = "Id dell'artista da ritornare", required = true, in = ParameterIn.PATH) @PathVariable("idArtista") Long idArtista) {

        ArtistaEAlbums artistaEAlbums = portaleService.artistandAlbum(idArtista);
        return new ResponseEntity<>(artistaEAlbums, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Album>> getAlbumsByGenre(@NotNull @Parameter(name = "genre", description = "Genere per filtrare gli album", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "genre") String genre) {

        logger.info("Chiamata al servizio getAlbumsByGenre con genre: {}", genre);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
