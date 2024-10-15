package it.apuliadigital.esercizio02portaleapi.mapper;

import it.apuliadigital.esercizio02portaleapi.client.album.model.AlbumDTO;
import it.apuliadigital.esercizio02portaleapi.model.Album;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlbumMapper {

    Album toAlbum(AlbumDTO albumDTO);

    AlbumDTO toAlbumDTO(Album album);

    List<Album> toAlbumList(List<AlbumDTO> albumDTO);

    List<AlbumDTO> toAlbumDTOList(List<Album> album);
}
