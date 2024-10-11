package it.apuliadigital.esercizio01albumapi.service.impl;


import it.apuliadigital.esercizio01albumapi.entity.AlbumEntity;
import it.apuliadigital.esercizio01albumapi.model.Album;
import it.apuliadigital.esercizio01albumapi.repository.SearchAlbumRepository;
import it.apuliadigital.esercizio01albumapi.service.SearchAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SearchAlbumServiceImpl implements SearchAlbumService {

    @Autowired
    private SearchAlbumRepository searchAlbumRepository;

    private Album getAlbum(Optional<AlbumEntity> entity) {

        if (entity.isEmpty()) {
            return null;
        }

        Album album = new Album();
        album.setIdAlbum(entity.get().getIdAlbum());
        album.setTitle(entity.get().getTitle());
        album.setAuthor(entity.get().getAuthor());
        album.setYear(entity.get().getYear());
        album.setDataUscita(entity.get().getReleaseDate());
        album.setGenere(entity.get().getGenre());
        album.setIsAvailable(entity.get().isAvailable());
        album.setBand(entity.get().getBand());
        album.setSongs(entity.get().getTracks());

        return album;
    }

    @Override
    public List<Album> searchAlbum(String author, Album.GenereEnum genre) {

        if (author != null && genre != null) {
            List<AlbumEntity> albumEntities = searchAlbumRepository.findByAuthorAndGenre(author, genre);
            List<Album> albums = new ArrayList<>();
            for (AlbumEntity entity : albumEntities) {
                albums.add(getAlbum(Optional.of(entity)));
            }
            return albums;
        }

        if (author != null) {
            List<AlbumEntity> albumEntities = searchAlbumRepository.findByAuthor(author);
            List<Album> albums = new ArrayList<>();
            for (AlbumEntity entity : albumEntities) {
                albums.add(getAlbum(Optional.of(entity)));
            }
            return albums;
        }

        if (genre != null) {
            List<AlbumEntity> albumEntities = searchAlbumRepository.findByGenre(genre);
            List<Album> albums = new ArrayList<>();
            for (AlbumEntity entity : albumEntities) {
                albums.add(getAlbum(Optional.of(entity)));
            }
            return albums;
        }

        return null;
    }
}
