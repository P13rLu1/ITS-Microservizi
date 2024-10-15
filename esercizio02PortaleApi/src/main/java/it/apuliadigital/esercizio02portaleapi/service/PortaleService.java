package it.apuliadigital.esercizio02portaleapi.service;

import it.apuliadigital.esercizio02portaleapi.model.Album;
import it.apuliadigital.esercizio02portaleapi.model.AlbumEArtista;
import it.apuliadigital.esercizio02portaleapi.model.ArtistaEAlbums;

import java.util.List;

public interface PortaleService {

    AlbumEArtista albumAndArtist(Long idAlbum);

    ArtistaEAlbums artistandAlbum(Long idArtista);

    List<Album> getAlbumsByGenre(String genre);
}
