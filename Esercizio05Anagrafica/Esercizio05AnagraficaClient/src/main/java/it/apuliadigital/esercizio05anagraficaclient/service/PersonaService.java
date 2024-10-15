package it.apuliadigital.esercizio05anagraficaclient.service;

import it.apuliadigital.esercizio05anagraficaclient.model.PersonaDTO;

import java.util.List;

public interface PersonaService {

    PersonaDTO createPersona(PersonaDTO personaDTO);

    PersonaDTO deletePersona(Long idPersona);

    List<PersonaDTO> getAllPersona();

    PersonaDTO updatePersona(PersonaDTO personaDTO, Long idPersona);

    PersonaDTO getPersonaById(Long idPersona);
}
