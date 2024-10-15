package it.apuliadigital.esercizio05anagraficaclient.mapper;

import it.apuliadigital.esercizio05anagraficaclient.entity.PersonaEntity;
import it.apuliadigital.esercizio05anagraficaclient.model.PersonaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = NumeriTelefoniciMapper.class)
public interface PersonaMapper {

    @Mapping(source = "numeriTelefonici", target = "numeriTelefonici", qualifiedByName = "stringToMap")
    PersonaDTO toPersonaDTO(PersonaEntity persona);

    @Mapping(source = "numeriTelefonici", target = "numeriTelefonici", qualifiedByName = "mapToString")
    PersonaEntity toPersonaEntity(PersonaDTO personaDTO);
}
