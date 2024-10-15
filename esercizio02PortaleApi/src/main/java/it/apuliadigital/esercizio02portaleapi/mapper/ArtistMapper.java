package it.apuliadigital.esercizio02portaleapi.mapper;

import it.apuliadigital.esercizio02portaleapi.model.Artist;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ArtistMapper {

    Artist toArtist(it.apuliadigital.esercizio02portaleapi.client.artista.model.Artist artist);

    it.apuliadigital.esercizio02portaleapi.client.artista.model.Artist toArtistDTO(Artist artist);
}
