package it.apuliadigital.esercizio04petapi.service;

import it.apuliadigital.esercizio04petapi.model.Pet;

import java.util.List;

public interface PetService {

    void createPets(Pet pet);

    List<Pet> listPets(Integer limit);

    Pet showPetById(String petId);
}
