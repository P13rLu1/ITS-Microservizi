package it.apuliadigital.esercizio05anagraficaclient.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.esercizio05anagraficaclient.api.PersonaApi;
import it.apuliadigital.esercizio05anagraficaclient.model.PersonaDTO;
import it.apuliadigital.esercizio05anagraficaclient.service.PersonaService;
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
public class PersonaController implements PersonaApi {

    Logger logger = LoggerFactory.getLogger(PersonaController.class);

    @Autowired
    private PersonaService personaService;

    @Override
    public ResponseEntity<PersonaDTO> creaPersona(@Parameter(name = "PersonaDTO", required = true) @Valid @RequestBody PersonaDTO personaDTO) {
        PersonaDTO persona = personaService.createPersona(personaDTO);

        logger.info("Persona creata con successo");

        return new ResponseEntity<>(persona, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PersonaDTO> eliminaPersona(@Parameter(name = "idAnagrafica", description = "L'ID dell'anagrafica", required = true, in = ParameterIn.PATH) @PathVariable("idAnagrafica") Long idAnagrafica) {
        PersonaDTO persona = personaService.deletePersona(idAnagrafica);

        logger.info("Persona eliminata con successo");

        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PersonaDTO>> listaPersone() {
        List<PersonaDTO> persone = personaService.getAllPersona();

        logger.info("Lista persone recuperata con successo");

        return new ResponseEntity<>(persone, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PersonaDTO> modificaPersona(@Parameter(name = "idAnagrafica", description = "L'ID dell'anagrafica", required = true, in = ParameterIn.PATH) @PathVariable("idAnagrafica") Long idAnagrafica, @Parameter(name = "PersonaDTO", required = true) @Valid @RequestBody PersonaDTO personaDTO) {

        PersonaDTO persona = personaService.updatePersona(personaDTO, idAnagrafica);

        logger.info("Persona modificata con successo");

        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PersonaDTO> persona(@Parameter(name = "idAnagrafica", description = "L'ID dell'anagrafica", required = true, in = ParameterIn.PATH) @PathVariable("idAnagrafica") Long idAnagrafica) {
        PersonaDTO persona = personaService.getPersonaById(idAnagrafica);

        logger.info("Persona recuperata con successo");

        return new ResponseEntity<>(persona, HttpStatus.OK);
    }
}
