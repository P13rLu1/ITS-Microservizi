package it.apuliadigital.esercizio01albumapi.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.esercizio01albumapi.api.AlbumApi;
import it.apuliadigital.esercizio01albumapi.api.ApiUtil;
import it.apuliadigital.esercizio01albumapi.model.Album;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class AlbumController implements AlbumApi {

    Logger logger = LoggerFactory.getLogger(AlbumController.class);

    @Override
    public ResponseEntity<Album> createAlbum(@Parameter(name = "Album", description = "Crea un nuovo album nello store", required = true) @RequestBody @Valid Album album) {
        album.setIdAlbum(666L);

        return new ResponseEntity<>(album, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Album> getAlbumById(@Parameter(name = "idAlbum", description = "ID of album to return", required = true, in = ParameterIn.PATH) @PathVariable("idAlbum") Long idAlbum) {

        List<Map<String, String>> l = new ArrayList<>();
        Map<String, String> bandMap = new HashMap<>();
        bandMap.put("Chitarra", "David Gilmour");
        bandMap.put("Batteria", "Nick Mason");
        bandMap.put("Basso", "Roger Waters");
        bandMap.put("Tastiere", "Richard Wright");
        l.add(bandMap);

        Album album = new Album();
        album.setAuthor("Pink Floyd");
        album.setBand(l);
        album.setGenere(Album.GenereEnum.ROCK);
        album.setIdAlbum(1L);
        album.setTitle("The Dark Side of the Moon");
        album.setYear(1973);

        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Album> addBandToAlbum(@Parameter(name = "idAlbum", description = "ID of album to return", required = true, in = ParameterIn.PATH) @PathVariable("idAlbum") Long idAlbum, @Parameter(name = "request_body", description = "Mette una band nell'album", required = true) @RequestBody @Valid Map<String, String> requestBody) {

        List<Map<String, String>> l = new ArrayList<>();
        Map<String, String> bandMap = new HashMap<>();
        bandMap.put("Chitarra", "David Gilmour");
        bandMap.put("Batteria", "Nick Mason");
        bandMap.put("Basso", "Roger Waters");
        bandMap.put("Tastiere", "Richard Wright");
        l.add(bandMap);

        Album album = new Album();
        album.setAuthor("Pink Floyd");
        album.setBand(l);
        album.setGenere(Album.GenereEnum.ROCK);
        album.setIdAlbum(2L);
        album.setTitle("The Wall");
        album.setYear(1979);

        return new ResponseEntity<>(album, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteAlbum(@Parameter(name = "idAlbum",description = "Id dell'album da eliminare",required = true,in = ParameterIn.PATH) @PathVariable("idAlbum") Long idAlbum) {

        logger.info("Album eliminato con successo");

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<List<Album>> findAlbumsByGenres(@Parameter(name = "genre",description = "Valori del genere che devono essere considerate per il filtro",required = true,in = ParameterIn.QUERY) @RequestParam(value = "genre",required = true,defaultValue = "rock") @NotNull @Valid String genre) {
        List<Map<String, String>> l = new ArrayList<>();
        Map<String, String> bandMap = new HashMap<>();
        bandMap.put("Chitarra", "David Gilmour");
        bandMap.put("Batteria", "Nick Mason");
        bandMap.put("Basso", "Roger Waters");
        bandMap.put("Tastiere", "Richard Wright");
        l.add(bandMap);

        Album album = new Album();
        album.setAuthor("Pink Floyd");
        album.setBand(l);
        album.setGenere(Album.GenereEnum.ROCK);
        album.setIdAlbum(1L);
        album.setTitle("The Wall");
        album.setYear(1979);

        return new ResponseEntity<>(Collections.singletonList(album), HttpStatus.OK);
    }
}
