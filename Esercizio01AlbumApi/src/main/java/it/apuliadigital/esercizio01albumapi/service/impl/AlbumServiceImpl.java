package it.apuliadigital.esercizio01albumapi.service.impl;

import it.apuliadigital.esercizio01albumapi.entity.AlbumEntity;
import it.apuliadigital.esercizio01albumapi.model.Album;
import it.apuliadigital.esercizio01albumapi.repository.AlbumRepository;
import it.apuliadigital.esercizio01albumapi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    AlbumRepository albumRepository;

    @Override
    public Album getAlbumById(Long idAlbum) {

        Optional<AlbumEntity> entity = albumRepository.findById(idAlbum);

        if (entity.isEmpty()) {
            throw new RuntimeException("Album not found");
        }

        return getAlbum(entity);
    }

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
    public Album createAlbum(Album album) {

        AlbumEntity entity = new AlbumEntity();
        entity = getAlbumEntity(album, entity);

        album.setIdAlbum(entity.getIdAlbum());

        return album;
    }

    private AlbumEntity getAlbumEntity(Album album, AlbumEntity entity) {
        entity.setTitle(album.getTitle());
        entity.setAuthor(album.getAuthor());
        entity.setYear(album.getYear());
        entity.setReleaseDate(album.getDataUscita());
        entity.setGenre(album.getGenere());
        entity.setAvailable(album.getIsAvailable());
        entity.setBand(album.getBand());
        entity.setTracks(album.getSongs());

        entity = albumRepository.save(entity);
        return entity;
    }

    @Override
    public Album deleteAlbum(Long idAlbum) {

        Optional<AlbumEntity> entity = albumRepository.findById(idAlbum);

        if (entity.isEmpty()) {
            return null;
        }

        albumRepository.deleteById(idAlbum);

        return getAlbum(entity);
    }

    @Override
    public Album updateAlbum(Album album, Long idAlbum) {

        Optional<AlbumEntity> entity = albumRepository.findById(idAlbum);

        if (entity.isEmpty()) {
            return null;
        }

        AlbumEntity albumEntity = entity.get();
        albumEntity = getAlbumEntity(album, albumEntity);

        return getAlbum(Optional.of(albumEntity));
    }

    @Override
    public Album addBand(Long idAlbum, List<String> band) {

        Optional<AlbumEntity> entity = albumRepository.findById(idAlbum);

        if (entity.isEmpty()) {
            return null;
        }

        AlbumEntity albumEntity = entity.get();
        albumEntity.setBand(band);

        albumEntity = albumRepository.save(albumEntity);

        return getAlbum(Optional.of(albumEntity));
    }

    @Override
    public List<Album> getAlbumByGenre(Album.GenereEnum genre) {

        List<Album> albums = new ArrayList<>();
        albumRepository.findByGenre(genre).forEach(entity -> albums.add(getAlbum(Optional.of(entity))));

        return albums;
    }
}
