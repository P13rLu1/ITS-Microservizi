package it.apuliadigital.esercizio05anagraficaserver.mapper;

import it.apuliadigital.esercizio05anagraficaserver.client.anagrafica.model.PersonaClient;
import it.apuliadigital.esercizio05anagraficaserver.model.PersonaServer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnagraficaMapper {

    PersonaServer toPersonaServer(PersonaClient personaClient);

    PersonaClient toPersonaClient(PersonaServer personaServer);

    List<PersonaServer> toPersonaServerList(List<PersonaClient> personaClient);

    List<PersonaClient> toPersonaClientList(List<PersonaServer> personaServer);
}
