package it.apuliadigital.esercizio01albumapi.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.esercizio01albumapi.api.AlbumApi;
import it.apuliadigital.esercizio01albumapi.model.Album;
import it.apuliadigital.esercizio01albumapi.service.AlbumService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class AlbumController implements AlbumApi {

    Logger logger = LoggerFactory.getLogger(AlbumController.class);

    @Autowired
    private AlbumService albumService;

    @Override
    public ResponseEntity<Album> createAlbum(@Parameter(name = "Album", description = "Crea un nuovo album nello store", required = true) @RequestBody @Valid Album album) {
        Album albumdto = albumService.createAlbum(album);
        logger.info("Album creato con successo");

        return new ResponseEntity<>(albumdto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Album> getAlbumById(@Parameter(name = "idAlbum", description = "ID of album to return", required = true, in = ParameterIn.PATH) @PathVariable("idAlbum") Long idAlbum) {
        Album albumdto = albumService.getAlbumById(idAlbum);

        return new ResponseEntity<>(albumdto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Album> deleteAlbum(@Parameter(name = "idAlbum", description = "Id dell'album da eliminare", required = true, in = ParameterIn.PATH) @PathVariable("idAlbum") Long idAlbum) {
        Album albumdto = albumService.deleteAlbum(idAlbum);
        logger.info("Album eliminato con successo");

        return new ResponseEntity<>(albumdto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Album> updateAlbum(
            @Parameter(name = "idAlbum", description = "Id dell'album da eliminare", required = true, in = ParameterIn.PATH) @PathVariable("idAlbum") Long idAlbum,
            @Parameter(name = "Album", description = "Aggiorna un album nello store", required = true) @Valid @RequestBody Album album
    ) {
        Album albumdto = albumService.updateAlbum(album, idAlbum);
        logger.info("Album aggiornato con successo");

        return new ResponseEntity<>(albumdto, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Album> addBandToAlbum(
            @Parameter(name = "idAlbum", description = "ID of album to return", required = true, in = ParameterIn.PATH) @PathVariable("idAlbum") Long idAlbum,
            @Parameter(name = "request_body", description = "Mette una band nell'album", required = true) @Valid @RequestBody List<String> requestBody
    ) {
        Album albumdto = albumService.addBand(idAlbum, requestBody);
        logger.info("Band aggiunta con successo");

        return new ResponseEntity<>(albumdto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Album>> findAlbumsByGenres(@Parameter(name = "genre", description = "Valori del genere che devono essere considerate per il filtro", required = true, in = ParameterIn.QUERY) @RequestParam(value = "genre", defaultValue = "rock") @NotNull @Valid String genre) {

        try{
            return new ResponseEntity<>(albumService.getAlbumByGenre(Album.GenereEnum.fromValue(genre)), HttpStatus.OK);
        }   catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
