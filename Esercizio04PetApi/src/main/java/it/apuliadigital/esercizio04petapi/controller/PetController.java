package it.apuliadigital.esercizio04petapi.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import it.apuliadigital.esercizio04petapi.api.PetsApi;
import it.apuliadigital.esercizio04petapi.model.Pet;
import it.apuliadigital.esercizio04petapi.service.PetService;
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
public class PetController implements PetsApi {

    Logger logger = LoggerFactory.getLogger(PetController.class);

    @Autowired
    private PetService petService;

    @Override
    public ResponseEntity<Void> createPets(@Parameter(name = "Pet", required = true) @Valid @RequestBody Pet pet) {
        logger.info("Pet creato con successo");

        petService.createPets(pet);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Pet>> listPets(@Max(100) @Parameter(name = "limit", description = "How many items to return at one time (max 100)", in = ParameterIn.QUERY) @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        List<Pet> pets = petService.listPets(limit);

        logger.info("Lista pet recuperata con successo");

        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Pet> showPetById(
            @Parameter(name = "petId", description = "The id of the pet to retrieve", required = true, in = ParameterIn.PATH) @PathVariable("petId") String petId
    ) {
        Pet pet = petService.showPetById(petId);

        logger.info("Pet recuperato con successo");

        return new ResponseEntity<>(pet, HttpStatus.OK);
    }
}
