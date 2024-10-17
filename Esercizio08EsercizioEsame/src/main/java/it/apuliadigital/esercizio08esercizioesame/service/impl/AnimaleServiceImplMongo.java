package it.apuliadigital.esercizio08esercizioesame.service.impl;

import it.apuliadigital.esercizio08esercizioesame.document.AnimaleDocument;
import it.apuliadigital.esercizio08esercizioesame.mapper.AnimaleMongoMapper;
import it.apuliadigital.esercizio08esercizioesame.repository.AnimaleRepositoryMongo;
import it.apuliadigital.esercizio08esercizioesame.server.model.PetDTO;
import it.apuliadigital.esercizio08esercizioesame.service.AnimaleServiceMongo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimaleServiceImplMongo implements AnimaleServiceMongo {

    Logger logger = LoggerFactory.getLogger(AnimaleServiceImplMongo.class);

    @Autowired
    private AnimaleRepositoryMongo animaleRepositoryMongo;

    @Autowired
    private AnimaleMongoMapper animaleMapper;

    @Override
    public PetDTO addPet(PetDTO petDTO){
        AnimaleDocument animaleDocument = animaleMapper.toAnimaleDocument(petDTO);
        animaleDocument = animaleRepositoryMongo.save(animaleDocument);
        logger.debug("Pet aggiunto con successo");
        return animaleMapper.animaleDocumentToPet(animaleDocument);
    }

    @Override
    public PetDTO deletePet(Long petId){
        Optional<AnimaleDocument> animaleDocument = animaleRepositoryMongo.findById(petId);
        if(animaleDocument.isEmpty()){
            return null;
        }
        animaleRepositoryMongo.deleteById(petId);
        logger.debug("Pet eliminato con successo");
        return animaleMapper.animaleDocumentToPet(animaleDocument.get());
    }

    @Override
    public PetDTO getPetById(Long petId){
        Optional<AnimaleDocument> animaleDocument = animaleRepositoryMongo.findById(petId);
        logger.debug("Pet recuperato con successo");
        return animaleDocument.map(animale -> animaleMapper.animaleDocumentToPet(animale)).orElse(null);
    }

    @Override
    public List<PetDTO> getAllPet(Integer limit){
        Optional<Integer> limitOptional = Optional.ofNullable(limit);
        return Streamable.of(animaleRepositoryMongo.findAll()).stream()
                .map(animale -> animaleMapper.animaleDocumentToPet(animale))
                .limit(limitOptional.orElse(100))
                .toList();
    }

    @Override
    public PetDTO updatePet(Long petId, PetDTO petDTO){
        Optional<AnimaleDocument> animaleDocument = animaleRepositoryMongo.findById(petId);
        if(animaleDocument.isEmpty()){
            return null;
        }

        AnimaleDocument animaleToUpdate = animaleMapper.toAnimaleDocument(petDTO);
        animaleToUpdate.setIdAnimale(petId);
        animaleToUpdate = animaleRepositoryMongo.save(animaleToUpdate);
        logger.debug("Pet modificato con successo");
        return animaleMapper.animaleDocumentToPet(animaleToUpdate);
    }
}
