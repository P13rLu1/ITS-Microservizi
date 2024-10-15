package it.apuliadigital.esercizio05anagraficaclient.service.impl;

import it.apuliadigital.esercizio05anagraficaclient.entity.PersonaEntity;
import it.apuliadigital.esercizio05anagraficaclient.mapper.PersonaMapper;
import it.apuliadigital.esercizio05anagraficaclient.model.PersonaDTO;
import it.apuliadigital.esercizio05anagraficaclient.repository.PersonaRepository;
import it.apuliadigital.esercizio05anagraficaclient.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    PersonaMapper personaMapper;

    @Override
    public PersonaDTO createPersona(PersonaDTO personaDTO){
        PersonaEntity personaEntity = personaMapper.toPersonaEntity(personaDTO);
        personaEntity = personaRepository.save(personaEntity);
        return personaMapper.toPersonaDTO(personaEntity);
    }

    @Override
    public PersonaDTO deletePersona(Long idPersona){
        Optional<PersonaEntity> personaEntity = personaRepository.findById(idPersona);
        if(personaEntity.isEmpty()){
            return null;
        }
        personaRepository.deleteById(idPersona);
        return personaMapper.toPersonaDTO(personaEntity.get());
    }

    @Override
    public List<PersonaDTO> getAllPersona(){
        List<PersonaEntity> persone = (List<PersonaEntity>) personaRepository.findAll();
        List<PersonaDTO> personeDTO = new ArrayList<>();
        for(PersonaEntity persona : persone){
            personeDTO.add(personaMapper.toPersonaDTO(persona));
        }
        return personeDTO;
    }

    @Override
    public PersonaDTO updatePersona(PersonaDTO personaDTO, Long idPersona){
        Optional<PersonaEntity> personaEntity = personaRepository.findById(idPersona);
        if(personaEntity.isEmpty()){
            return null;
        }

        PersonaEntity personaToUpdate = personaMapper.toPersonaEntity(personaDTO);
        personaToUpdate.setIdAnagrafica(idPersona);
        personaToUpdate = personaRepository.save(personaToUpdate);
        return personaMapper.toPersonaDTO(personaToUpdate);
    }

    @Override
    public PersonaDTO getPersonaById(Long idPersona){
        Optional<PersonaEntity> personaEntity = personaRepository.findById(idPersona);
        return personaEntity.map(entity -> personaMapper.toPersonaDTO(entity)).orElse(null);
    }
}
