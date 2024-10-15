package it.apuliadigital.esercizio04petapi.service.impl;

import it.apuliadigital.esercizio04petapi.entity.Animaletto;
import it.apuliadigital.esercizio04petapi.mapper.AnimalettoToPetMapper;
import it.apuliadigital.esercizio04petapi.mapper.PetToAnimalettoMapper;
import it.apuliadigital.esercizio04petapi.model.Pet;
import it.apuliadigital.esercizio04petapi.repository.PetRepository;
import it.apuliadigital.esercizio04petapi.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    PetRepository petRepository;

    @Autowired
    AnimalettoToPetMapper animalettoToPetMapper;

    @Autowired
    PetToAnimalettoMapper petToAnimalettoMapper;

    @Override
    public void createPets(Pet pet) {
        Animaletto animaletto = petToAnimalettoMapper.petToAnimaletto(pet);
        petRepository.save(animaletto);
    }

    @Override
    public List<Pet> listPets(Integer limit) {
        Optional<Integer> limitOptional = Optional.ofNullable(limit);
        return Streamable.of(petRepository.findAll()).stream()
                .map(animaletto -> animalettoToPetMapper.animalettoToPet(animaletto))
                .limit(limitOptional.orElse(100))
                .toList();
    }

    @Override
    public Pet showPetById(String petId) {
        Optional<Animaletto> animaletto = petRepository.findById(Long.parseLong(petId));
        return animaletto.map(value -> animalettoToPetMapper.animalettoToPet(value))
                .orElse(null);
    }
}
