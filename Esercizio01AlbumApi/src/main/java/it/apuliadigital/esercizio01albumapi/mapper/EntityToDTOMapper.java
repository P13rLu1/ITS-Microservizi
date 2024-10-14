package it.apuliadigital.esercizio01albumapi.mapper;

import it.apuliadigital.esercizio01albumapi.controller.dto.Contact;
import it.apuliadigital.esercizio01albumapi.entity.AlbumEntity;
import it.apuliadigital.esercizio01albumapi.entity.Contatto;
import it.apuliadigital.esercizio01albumapi.model.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EntityToDTOMapper {
    @Mapping(source = "releaseDate", target = "dataUscita")
    @Mapping(source = "genre", target = "genere")
    @Mapping(source = "available", target = "isAvailable")
    @Mapping(source = "tracks", target = "songs")
    Album entityToDto(AlbumEntity albumEntity);

    @Mapping(target = "contactType", source = "contatto.tipoContatto")
    @Mapping(target = "contact", source = "contatto.contatto")
    Contact contattoToContact(Contatto contatto);
}
