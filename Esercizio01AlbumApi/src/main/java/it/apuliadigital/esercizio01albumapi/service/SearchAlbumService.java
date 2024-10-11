package it.apuliadigital.esercizio01albumapi.service;

import it.apuliadigital.esercizio01albumapi.model.Album;

import java.util.List;

public interface SearchAlbumService {

    List<Album> searchAlbum(String author, Album.GenereEnum genre);
}
