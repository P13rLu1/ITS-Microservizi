package it.apuliadigital.esercizio05anagraficaclient.repository;

import it.apuliadigital.esercizio05anagraficaclient.entity.PersonaEntity;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<PersonaEntity, Long> {
}
