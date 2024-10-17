package it.apuliadigital.esercizio08esercizioesame.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.esercizio08esercizioesame.server.api.PetsApi;
import it.apuliadigital.esercizio08esercizioesame.server.model.PetDTO;
import it.apuliadigital.esercizio08esercizioesame.service.AnimaleService;
import it.apuliadigital.esercizio08esercizioesame.service.AnimaleServiceMongo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
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
public class AnimaleController implements PetsApi {

    Logger logger = LoggerFactory.getLogger(AnimaleController.class);

    @Autowired
    private AnimaleService animaleService;

    @Autowired
    private AnimaleServiceMongo animaleServiceMongo;

    @Override
    public ResponseEntity<PetDTO> addPet(@Parameter(name = "PetDTO", required = true) @Valid @RequestBody PetDTO petDTO) {
//        PetDTO pet = animaleService.addPet(petDTO);

        PetDTO pet = animaleServiceMongo.addPet(petDTO);

        logger.info("Pet aggiunto con successo");

        return new ResponseEntity<>(pet, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<PetDTO> deletePet(@Parameter(name = "petId", description = "ID of pet to return", required = true, in = ParameterIn.PATH) @PathVariable("petId") Long petId) {
//        PetDTO pet = animaleService.deletePet(petId);
        PetDTO pet = animaleServiceMongo.deletePet(petId);

        logger.info("Pet eliminato con successo");

        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PetDTO> getPetById(@Parameter(name = "petId", description = "ID of pet to return", required = true, in = ParameterIn.PATH) @PathVariable("petId") Long petId) {
//        PetDTO pet = animaleService.getPetById(petId);
        PetDTO pet = animaleServiceMongo.getPetById(petId);

        logger.info("Pet recuperato con successo");

        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PetDTO>> getPets(@Max(100) @Parameter(name = "limit", description = "How many items to return at one time (max 100)", in = ParameterIn.QUERY) @Valid @RequestParam(value = "limit", required = false) Integer limit) {
//        List<PetDTO> pets = animaleService.getAllPet(limit);
        List<PetDTO> pets = animaleServiceMongo.getAllPet(limit);

        logger.info("Lista pet recuperata con successo");

        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PetDTO> updatePet(@Parameter(name = "petId", description = "ID of pet to return", required = true, in = ParameterIn.PATH) @PathVariable("petId") Long petId, @Parameter(name = "PetDTO", required = true) @Valid @RequestBody PetDTO petDTO) {
//        PetDTO pet = animaleService.updatePet(petId, petDTO);
        PetDTO pet = animaleServiceMongo.updatePet(petId, petDTO);

        logger.info("Pet modificato con successo");

        return new ResponseEntity<>(pet, HttpStatus.OK);
    }
}
