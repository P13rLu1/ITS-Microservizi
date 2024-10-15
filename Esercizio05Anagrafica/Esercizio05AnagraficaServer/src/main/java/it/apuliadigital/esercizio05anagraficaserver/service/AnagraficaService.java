package it.apuliadigital.esercizio05anagraficaserver.service;

import it.apuliadigital.esercizio05anagraficaserver.model.PersonaServer;

import java.util.List;

public interface AnagraficaService {

    PersonaServer creaPersona(PersonaServer personaServer);

    PersonaServer eliminaPersona(Long idAnagrafica);

    List<PersonaServer> listaPersone();

    PersonaServer modificaPersona(PersonaServer personaServer, Long idAnagrafica);

    PersonaServer getPersonaById(Long idAnagrafica);
}
