package it.its.formazione.springbootesercizio2pierluigibuttazzo.repository;

import it.its.formazione.springbootesercizio2pierluigibuttazzo.entity.BookingEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<BookingEntity, Integer> {
}
