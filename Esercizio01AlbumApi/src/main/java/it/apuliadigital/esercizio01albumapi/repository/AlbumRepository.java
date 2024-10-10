package it.apuliadigital.esercizio01albumapi.repository;

import it.apuliadigital.esercizio01albumapi.entity.AlbumEntity;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<AlbumEntity, Long> {
}
