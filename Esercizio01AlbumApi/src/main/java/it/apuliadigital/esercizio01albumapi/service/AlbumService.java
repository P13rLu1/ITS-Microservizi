package it.apuliadigital.esercizio01albumapi.service;

import it.apuliadigital.esercizio01albumapi.model.Album;

public interface AlbumService {

    Album getAlbumById(Long idAlbum);

    Album createAlbum(Album album);

    Album deleteAlbum(Long idAlbum);
}
