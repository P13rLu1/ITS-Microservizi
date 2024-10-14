package it.apuliadigital.esercizio03menuapi.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.esercizio03menuapi.api.MenuApi;
import it.apuliadigital.esercizio03menuapi.model.PiattoDTO;
import it.apuliadigital.esercizio03menuapi.service.MenuService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController implements MenuApi {

    Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;

    @Override
    public ResponseEntity<PiattoDTO> creaPiatto(@Parameter(name = "PiattoDTO", required = true) @Valid @RequestBody PiattoDTO piattoDTO) {
        PiattoDTO piatto = menuService.createPiatto(piattoDTO);
        logger.info("Piatto creato con successo");

        return new ResponseEntity<>(piatto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PiattoDTO> eliminaPiatto(@Parameter(name = "idPiatto", description = "L'ID del piatto", required = true, in = ParameterIn.PATH) @PathVariable("idPiatto") Long idPiatto) {
        PiattoDTO piatto = menuService.deletePiatto(idPiatto);
        logger.info("Piatto eliminato con successo");

        return new ResponseEntity<>(piatto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PiattoDTO>> listaPiatti() {
        List<PiattoDTO> piatti = menuService.getAllPiatto();

        return new ResponseEntity<>(piatti, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PiattoDTO>> listaPiattiTipologia(@NotNull @Parameter(name = "tipologiaPiatto", description = "La tipologia del piatto", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "tipologiaPiatto") String tipologiaPiatto) {
        List<PiattoDTO> piatti = menuService.getPiattoByType(PiattoDTO.TipologiaPiattoEnum.fromValue(tipologiaPiatto));
        logger.info("Lista piatti filtrata per tipologia");

        return new ResponseEntity<>(piatti, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PiattoDTO> modificaPiatto(@Parameter(name = "idPiatto", description = "L'ID del piatto", required = true, in = ParameterIn.PATH) @PathVariable("idPiatto") Long idPiatto, @Parameter(name = "PiattoDTO", required = true) @Valid @RequestBody PiattoDTO piattoDTO) {
        PiattoDTO piatto = menuService.updatePiatto(piattoDTO, idPiatto);
        logger.info("Piatto modificato con successo");

        return new ResponseEntity<>(piatto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PiattoDTO> piatto(@Parameter(name = "idPiatto", description = "L'ID del piatto", required = true, in = ParameterIn.PATH) @PathVariable("idPiatto") Long idPiatto) {
        PiattoDTO piatto = menuService.getPiattoById(idPiatto);

        return new ResponseEntity<>(piatto, HttpStatus.OK);
    }
}
