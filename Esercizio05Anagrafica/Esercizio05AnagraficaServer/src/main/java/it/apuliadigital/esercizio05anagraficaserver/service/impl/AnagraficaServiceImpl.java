package it.apuliadigital.esercizio05anagraficaserver.service.impl;

import it.apuliadigital.esercizio05anagraficaserver.client.anagrafica.api.PersonaApi;
import it.apuliadigital.esercizio05anagraficaserver.client.anagrafica.model.PersonaClient;
import it.apuliadigital.esercizio05anagraficaserver.mapper.AnagraficaMapper;
import it.apuliadigital.esercizio05anagraficaserver.model.PersonaServer;
import it.apuliadigital.esercizio05anagraficaserver.service.AnagraficaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnagraficaServiceImpl implements AnagraficaService {

    @Autowired
    private PersonaApi personaApiClient;

    @Autowired
    private AnagraficaMapper anagraficaMapper;

    @Override
    public PersonaServer creaPersona(PersonaServer personaServer) {
        PersonaClient personaClient = personaApiClient.creaPersona(anagraficaMapper.toPersonaClient(personaServer));

        return anagraficaMapper.toPersonaServer(personaClient);
    }

    @Override
    public PersonaServer eliminaPersona(Long idAnagrafica) {
        PersonaClient personaClient = personaApiClient.eliminaPersona(idAnagrafica);

        return anagraficaMapper.toPersonaServer(personaClient);
    }

    @Override
    public List<PersonaServer> listaPersone() {
        return anagraficaMapper.toPersonaServerList(personaApiClient.listaPersone());
    }

    @Override
    public PersonaServer modificaPersona(PersonaServer personaServer, Long idAnagrafica) {
        PersonaClient personaClient = personaApiClient.modificaPersona(idAnagrafica, anagraficaMapper.toPersonaClient(personaServer));

        return anagraficaMapper.toPersonaServer(personaClient);
    }

    @Override
    public PersonaServer getPersonaById(Long idAnagrafica) {
        PersonaClient personaClient = personaApiClient.persona(idAnagrafica);

        return anagraficaMapper.toPersonaServer(personaClient);
    }
}
