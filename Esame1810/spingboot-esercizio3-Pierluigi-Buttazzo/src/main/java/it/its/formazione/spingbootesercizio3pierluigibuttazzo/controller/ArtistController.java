package it.its.formazione.spingbootesercizio3pierluigibuttazzo.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.its.formazione.spingbootesercizio3pierluigibuttazzo.server.api.ArtistApi;
import it.its.formazione.spingbootesercizio3pierluigibuttazzo.server.model.ArtistDTO;
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
public class ArtistController implements ArtistApi {

    Logger logger = LoggerFactory.getLogger(ArtistController.class);

    @Override
    public ResponseEntity<ArtistDTO> creaArtista(@Parameter(name = "ArtistDTO", required = true) @Valid @RequestBody ArtistDTO artistDTO) {
        logger.info("Entrata nel metodo creaArtista");
        logger.info("Uscita dal metodo creaArtista");

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ArtistDTO> eliminaArtista(@Parameter(name = "id", description = "L'ID dell'artista", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id) {
        logger.info("Entrata nel metodo eliminaArtista");
        logger.info("Uscita dal metodo eliminaArtista");

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<ArtistDTO> getArtista(@Parameter(name = "id", description = "L'ID dell'artista", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id) {
        logger.info("Entrata nel metodo getArtista");
        logger.info("Uscita dal metodo getArtista");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<ArtistDTO>> listaArtisti() {
        logger.info("Entrata nel metodo listaArtisti");
        logger.info("Uscita dal metodo listaArtisti");

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ArtistDTO> modificaArtista(@Parameter(name = "id", description = "L'ID dell'artista", required = true, in = ParameterIn.PATH) @PathVariable("id") Integer id, @Parameter(name = "ArtistDTO", required = true) @Valid @RequestBody ArtistDTO artistDTO) {
        logger.info("Entrata nel metodo modificaArtista");
        logger.info("Uscita dal metodo modificaArtista");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
