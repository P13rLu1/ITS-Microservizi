package it.apuliadigital.esercizio01albumapi.service.impl;


import it.apuliadigital.esercizio01albumapi.entity.AlbumEntity;
import it.apuliadigital.esercizio01albumapi.mapper.EntityToDTOMapper;
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

    @Autowired
    EntityToDTOMapper entityToDTOMapper;

    @Override
    public List<Album> searchAlbum(String author, Album.GenereEnum genre) {

        if (author != null && genre != null) {
            List<AlbumEntity> albumEntities = searchAlbumRepository.findByAuthorAndGenre(author, genre);
            List<Album> albums = new ArrayList<>();
            for (AlbumEntity entity : albumEntities) {
                albums.add(entityToDTOMapper.entityToDto(Optional.of(entity).get()));
            }
            return albums;
        }

        if (author != null) {
            List<AlbumEntity> albumEntities = searchAlbumRepository.findByAuthor(author);
            List<Album> albums = new ArrayList<>();
            for (AlbumEntity entity : albumEntities) {
                albums.add(entityToDTOMapper.entityToDto(Optional.of(entity).get()));
            }
            return albums;
        }

        if (genre != null) {
            List<AlbumEntity> albumEntities = searchAlbumRepository.findByGenre(genre);
            List<Album> albums = new ArrayList<>();
            for (AlbumEntity entity : albumEntities) {
                albums.add(entityToDTOMapper.entityToDto(Optional.of(entity).get()));
            }
            return albums;
        }

        return null;
    }
}
