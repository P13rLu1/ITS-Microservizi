package it.its.formazione.spingbootesercizio3pierluigibuttazzo.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.its.formazione.spingbootesercizio3pierluigibuttazzo.server.api.AlbumApi;
import it.its.formazione.spingbootesercizio3pierluigibuttazzo.server.model.AlbumDTO;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlbumController implements AlbumApi {

    Logger logger = LoggerFactory.getLogger(AlbumController.class);

    @Override
    public ResponseEntity<AlbumDTO> creaAlbum(@Parameter(name = "AlbumDTO", required = true) @Valid @RequestBody AlbumDTO albumDTO) {
        logger.info("entrato in creaAlbum");
        logger.info("uscito da creaAlbum");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<AlbumDTO> eliminaAlbum(@Parameter(name = "id", description = "L'ID dell'album", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id) {
        logger.info("entrato in eliminaAlbum");
        logger.info("uscito da eliminaAlbum");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<AlbumDTO> getAlbum(@Parameter(name = "id", description = "L'ID dell'album", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id) {
        logger.info("entrato in getAlbum");
        logger.info("uscito da getAlbum");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AlbumDTO>> listaAlbum() {
        logger.info("entrato in listaAlbum");
        logger.info("uscito da listaAlbum");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AlbumDTO> modificaAlbum(
            @Parameter(name = "id", description = "L'ID dell'album", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id,
            @Parameter(name = "AlbumDTO", required = true) @Valid @RequestBody AlbumDTO albumDTO
    ) {
        logger.info("entrato in modificaAlbum");
        logger.info("uscito da modificaAlbum");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
