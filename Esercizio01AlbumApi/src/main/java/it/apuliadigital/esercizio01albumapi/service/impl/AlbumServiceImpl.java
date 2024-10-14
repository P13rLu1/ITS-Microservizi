package it.apuliadigital.esercizio01albumapi.service.impl;

import it.apuliadigital.esercizio01albumapi.entity.AlbumEntity;
import it.apuliadigital.esercizio01albumapi.mapper.DTOToEntityMapper;
import it.apuliadigital.esercizio01albumapi.mapper.EntityToDTOMapper;
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

    @Autowired
    EntityToDTOMapper entityToDTOMapper;

    @Autowired
    DTOToEntityMapper dtoToEntityMapper;

    @Override
    public Album getAlbumById(Long idAlbum) {

        Optional<AlbumEntity> entity = albumRepository.findById(idAlbum);

        if (entity.isEmpty()) {
            throw new RuntimeException("Album not found");
        }

        return entityToDTOMapper.entityToDto(entity.get());
    }

    @Override
    public Album createAlbum(Album album) {

            AlbumEntity albumEntity = dtoToEntityMapper.dtoToEntity(album);
            albumEntity = albumRepository.save(albumEntity);

            return entityToDTOMapper.entityToDto(albumEntity);
    }

    @Override
    public Album deleteAlbum(Long idAlbum) {

        Optional<AlbumEntity> entity = albumRepository.findById(idAlbum);

        if (entity.isEmpty()) {
            return null;
        }

        albumRepository.deleteById(idAlbum);

        return entityToDTOMapper.entityToDto(entity.get());
    }

    @Override
    public Album updateAlbum(Album album, Long idAlbum) {

        Optional<AlbumEntity> entity = albumRepository.findById(idAlbum);

        if (entity.isEmpty()) {
            return null;
        }

        AlbumEntity albumEntity = dtoToEntityMapper.dtoToEntity(album);
        albumEntity.setIdAlbum(idAlbum);
        albumEntity = albumRepository.save(albumEntity);

        return entityToDTOMapper.entityToDto(albumEntity);
    }

    @Override
    public Album addBand(Long idAlbum, List<String> band) {

        Optional<AlbumEntity> entity = albumRepository.findById(idAlbum);

        if (entity.isEmpty()) {
            return null;
        }

        AlbumEntity albumEntity = entity.get();
        albumEntity.setBand(new ArrayList<>(band));
        albumEntity = albumRepository.save(albumEntity);

        return entityToDTOMapper.entityToDto(albumEntity);
    }

    @Override
    public List<Album> getAlbumByGenre(Album.GenereEnum genre) {

        List<AlbumEntity> entities = albumRepository.findByGenre(genre);

        List<Album> albums = new ArrayList<>();
        for (AlbumEntity entity : entities) {
            albums.add(entityToDTOMapper.entityToDto(entity));
        }

        return albums;
    }
}
