package it.apuliadigital.esercizio01albumapi.service;

import it.apuliadigital.esercizio01albumapi.model.Album;

import java.util.List;

public interface AlbumService {

    Album getAlbumById(Long idAlbum);

    Album createAlbum(Album album);

    Album deleteAlbum(Long idAlbum);

    Album updateAlbum(Album album, Long idAlbum);

    Album addBand(Long idAlbum, List<String> band);

    List<Album> getAlbumByGenre( Album.GenereEnum genre);
}
