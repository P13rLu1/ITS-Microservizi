package it.apuliadigital.esercizio04petapi.mapper;

import it.apuliadigital.esercizio04petapi.entity.Animaletto;
import it.apuliadigital.esercizio04petapi.model.Pet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetToAnimalettoMapper {

    Animaletto petToAnimaletto(Pet pet);
}
