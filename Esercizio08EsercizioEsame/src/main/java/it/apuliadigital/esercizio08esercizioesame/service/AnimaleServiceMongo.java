package it.apuliadigital.esercizio08esercizioesame.service;

import it.apuliadigital.esercizio08esercizioesame.server.model.PetDTO;

import java.util.List;

public interface AnimaleServiceMongo {
    PetDTO addPet(PetDTO petDTO);

    PetDTO deletePet(Long petId);

    PetDTO getPetById(Long petId);

    List<PetDTO> getAllPet(Integer limit);

    PetDTO updatePet(Long petId, PetDTO petDTO);
}
