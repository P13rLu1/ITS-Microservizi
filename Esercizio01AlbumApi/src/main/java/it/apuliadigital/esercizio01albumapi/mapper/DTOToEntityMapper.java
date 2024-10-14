package it.apuliadigital.esercizio01albumapi.mapper;

import it.apuliadigital.esercizio01albumapi.controller.dto.Contact;
import it.apuliadigital.esercizio01albumapi.entity.AlbumEntity;
import it.apuliadigital.esercizio01albumapi.entity.Contatto;
import it.apuliadigital.esercizio01albumapi.model.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DTOToEntityMapper {
    @Mapping(source = "dataUscita", target = "releaseDate")
    @Mapping(source = "genere", target = "genre")
    @Mapping(source = "isAvailable", target = "available")
    @Mapping(source = "songs", target = "tracks")
    AlbumEntity dtoToEntity(Album album);

    @Mapping(target = "tipoContatto", source = "contact.contactType")
    @Mapping(target = "contatto", source = "contact.contact")
    Contatto contactToContatto(Contact contact);
}
