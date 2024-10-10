package it.apuliadigital.esercizio01albumapi.service.impl;

import it.apuliadigital.esercizio01albumapi.entity.AlbumEntity;
import it.apuliadigital.esercizio01albumapi.model.Album;
import it.apuliadigital.esercizio01albumapi.repository.AlbumRepository;
import it.apuliadigital.esercizio01albumapi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    @Override
    public Album getAlbumById(Long idAlbum) {

        Optional<AlbumEntity> entity = albumRepository.findById(idAlbum);

        if (entity.isEmpty()) {
            return null;
        }

        Album album = new Album();
        album.setIdAlbum(idAlbum);
        album.setTitle(entity.get().getTitle());
        album.setAuthor(entity.get().getAuthor());

        return album;
    }

    @Override
    public Album createAlbum(Album album) {

        AlbumEntity entity = new AlbumEntity();
        entity.setTitle(album.getTitle());
        entity.setAuthor(album.getAuthor());

        albumRepository.save(entity);

        return album;
    }

    @Override
    public Album deleteAlbum(Long idAlbum) {

        Optional<AlbumEntity> entity = albumRepository.findById(idAlbum);

        if (entity.isEmpty()) {
            return null;
        }

        albumRepository.deleteById(idAlbum);

        Album album = new Album();
        album.setIdAlbum(idAlbum);
        album.setTitle(entity.get().getTitle());
        album.setAuthor(entity.get().getAuthor());

        return album;
    }
}
