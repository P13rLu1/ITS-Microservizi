package it.apuliadigital.esercizio01albumapi.repository;

import it.apuliadigital.esercizio01albumapi.entity.AlbumEntity;
import it.apuliadigital.esercizio01albumapi.model.Album;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SearchAlbumRepository extends CrudRepository<AlbumEntity, Long> {

    List<AlbumEntity> findByAuthor(String author);

    List<AlbumEntity> findByGenre(Album.GenereEnum genre);

    List<AlbumEntity> findByAuthorAndGenre(String author, Album.GenereEnum genre);
}
