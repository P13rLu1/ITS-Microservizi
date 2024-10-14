package it.apuliadigital.esercizio03menuapi.repository;

import it.apuliadigital.esercizio03menuapi.entity.Pietanza;
import it.apuliadigital.esercizio03menuapi.model.PiattoDTO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MenuRepository extends CrudRepository<Pietanza, Long> {

    List<Pietanza> findByTipologiaPietanza(PiattoDTO.TipologiaPiattoEnum type);
}
