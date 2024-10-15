package it.apuliadigital.esercizio05anagraficaserver.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.esercizio05anagraficaserver.api.PersonaApi;
import it.apuliadigital.esercizio05anagraficaserver.model.PersonaServer;
import it.apuliadigital.esercizio05anagraficaserver.service.AnagraficaService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnagraficaController implements PersonaApi {

    Logger logger = LoggerFactory.getLogger(AnagraficaController.class);

    @Autowired
    private AnagraficaService anagraficaService;

    @Override
    public ResponseEntity<PersonaServer> creaPersona(@Parameter(name = "PersonaServer", required = true) @Valid @RequestBody PersonaServer personaServer) {

        PersonaServer persona = anagraficaService.creaPersona(personaServer);

        logger.info("Persona creata con successo");

        return new ResponseEntity<>(persona, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PersonaServer> eliminaPersona(@Parameter(name = "idAnagrafica", description = "L'ID dell'anagrafica", required = true, in = ParameterIn.PATH) @PathVariable("idAnagrafica") Long idAnagrafica) {

        PersonaServer persona = anagraficaService.eliminaPersona(idAnagrafica);

        logger.info("Persona eliminata con successo");

        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PersonaServer>> listaPersone() {

        List<PersonaServer> persone = anagraficaService.listaPersone();

        logger.info("Lista persone recuperata con successo");

        return new ResponseEntity<>(persone, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PersonaServer> modificaPersona(@Parameter(name = "idAnagrafica", description = "L'ID dell'anagrafica", required = true, in = ParameterIn.PATH) @PathVariable("idAnagrafica") Long idAnagrafica, @Parameter(name = "PersonaServer", required = true) @Valid @RequestBody PersonaServer personaServer) {

        PersonaServer persona = anagraficaService.modificaPersona(personaServer, idAnagrafica);

        logger.info("Persona modificata con successo");

        return new ResponseEntity<>(persona, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<PersonaServer> persona(@Parameter(name = "idAnagrafica", description = "L'ID dell'anagrafica", required = true, in = ParameterIn.PATH) @PathVariable("idAnagrafica") Long idAnagrafica) {

        PersonaServer persona = anagraficaService.getPersonaById(idAnagrafica);

        logger.info("Persona recuperata con successo");

        return new ResponseEntity<>(persona, HttpStatus.OK);
    }
}
