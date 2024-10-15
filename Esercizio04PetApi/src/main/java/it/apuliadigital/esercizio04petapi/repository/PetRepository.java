package it.apuliadigital.esercizio04petapi.repository;

import it.apuliadigital.esercizio04petapi.entity.Animaletto;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Animaletto, Long> {
}
