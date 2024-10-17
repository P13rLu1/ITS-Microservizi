package it.apuliadigital.esercizio08esercizioesame.repository;

import it.apuliadigital.esercizio08esercizioesame.document.AnimaleDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnimaleRepositoryMongo extends MongoRepository<AnimaleDocument, Long> {
}
