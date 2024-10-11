package it.apuliadigital.esercizio01albumapi.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.esercizio01albumapi.api.SearchAlbumApi;
import it.apuliadigital.esercizio01albumapi.model.Album;
import it.apuliadigital.esercizio01albumapi.service.SearchAlbumService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchAlbumController implements SearchAlbumApi {

    Logger logger = LoggerFactory.getLogger(SearchAlbumController.class);

    @Autowired
    private SearchAlbumService searchAlbumService;

    @Override
    public ResponseEntity<List<Album>> searchAlbumGet(
            @Parameter(name = "author", description = "Il Nome Dell'artista", in = ParameterIn.QUERY) @Valid @RequestParam(value = "author", required = false) String author,
            @Parameter(name = "genre", description = "Il Genere Dell'album", in = ParameterIn.QUERY) @Valid @RequestParam(value = "genre", required = false) String genre
    ) {

        logger.info("Ricerca Album");
        if (author == null) {
            return new ResponseEntity<>(searchAlbumService.searchAlbum(null, Album.GenereEnum.fromValue(genre)), HttpStatus.OK);
        } else if (genre == null) {
            return new ResponseEntity<>(searchAlbumService.searchAlbum(author, null), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(searchAlbumService.searchAlbum(author, Album.GenereEnum.fromValue(genre)), HttpStatus.OK);
        }
    }
}
