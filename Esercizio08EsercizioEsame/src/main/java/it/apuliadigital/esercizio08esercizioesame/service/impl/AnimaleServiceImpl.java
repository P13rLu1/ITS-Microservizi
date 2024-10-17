package it.apuliadigital.esercizio08esercizioesame.service.impl;

import it.apuliadigital.esercizio08esercizioesame.entity.AnimaleEntity;
import it.apuliadigital.esercizio08esercizioesame.mapper.AnimaleMapper;
import it.apuliadigital.esercizio08esercizioesame.repository.AnimaleRepository;
import it.apuliadigital.esercizio08esercizioesame.server.model.PetDTO;
import it.apuliadigital.esercizio08esercizioesame.service.AnimaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimaleServiceImpl implements AnimaleService {

    Logger logger = LoggerFactory.getLogger(AnimaleServiceImpl.class);

    @Autowired
    AnimaleRepository animaleRepository;

    @Autowired
    AnimaleMapper animaleMapper;

    @Override
    public PetDTO addPet(PetDTO petDTO){
        AnimaleEntity animaleEntity = animaleMapper.petToAnimaleEntity(petDTO);
        animaleEntity = animaleRepository.save(animaleEntity);
        logger.debug("Pet aggiunto con successo");
        return animaleMapper.animaleEntityToPet(animaleEntity);
    }

    @Override
    public PetDTO deletePet(Long petId){
        Optional<AnimaleEntity> animaleEntity = animaleRepository.findById(petId);
        if(animaleEntity.isEmpty()){
            return null;
        }
        animaleRepository.deleteById(petId);
        logger.debug("Pet eliminato con successo");
        return animaleMapper.animaleEntityToPet(animaleEntity.get());
    }

    @Override
    public PetDTO getPetById(Long petId){
        Optional<AnimaleEntity> animaleEntity = animaleRepository.findById(petId);
        logger.debug("Pet recuperato con successo");
        return animaleEntity.map(entity -> animaleMapper.animaleEntityToPet(entity)).orElse(null);
    }

    @Override
    public List<PetDTO> getAllPet(Integer limit){
        Optional<Integer> limitOptional = Optional.ofNullable(limit);
        logger.debug("Lista pet recuperata con successo");
        return Streamable.of(animaleRepository.findAll()).stream()
                .map(animaleEntity -> animaleMapper.animaleEntityToPet(animaleEntity))
                .limit(limitOptional.orElse(100))
                .toList();
    }

    @Override
    public PetDTO updatePet(Long petId, PetDTO petDTO){
        Optional<AnimaleEntity> animaleEntity = animaleRepository.findById(petId);
        if (animaleEntity.isEmpty()){
            return null;
        }

        AnimaleEntity animaleToUpdate = animaleMapper.petToAnimaleEntity(petDTO);
        animaleToUpdate.setIdAnimale(petId);
        animaleToUpdate = animaleRepository.save(animaleToUpdate);
        logger.debug("Pet aggiornato con successo");
        return animaleMapper.animaleEntityToPet(animaleToUpdate);
    }
}
