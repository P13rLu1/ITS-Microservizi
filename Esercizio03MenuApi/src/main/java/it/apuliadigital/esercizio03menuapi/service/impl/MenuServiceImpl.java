package it.apuliadigital.esercizio03menuapi.service.impl;

import it.apuliadigital.esercizio03menuapi.entity.Pietanza;
import it.apuliadigital.esercizio03menuapi.mapper.DtoToEntityMapper;
import it.apuliadigital.esercizio03menuapi.mapper.EntityToDtoMapper;
import it.apuliadigital.esercizio03menuapi.model.PiattoDTO;
import it.apuliadigital.esercizio03menuapi.repository.MenuRepository;
import it.apuliadigital.esercizio03menuapi.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    EntityToDtoMapper pietanzaToPiatto;

    @Autowired
    DtoToEntityMapper piattoToPietanza;

    @Override
    public PiattoDTO createPiatto(PiattoDTO piattoDTO) {
        Pietanza pietanza = piattoToPietanza.piattoToPietanza(piattoDTO);
        pietanza = menuRepository.save(pietanza);
        return pietanzaToPiatto.pietanzaToPiatto(pietanza);
    }

    @Override
    public PiattoDTO deletePiatto(Long idPiatto) {
        Optional<Pietanza> pietanza = menuRepository.findById(idPiatto);
        if (pietanza.isEmpty()) {
            return null;
        }
        menuRepository.deleteById(idPiatto);
        return pietanzaToPiatto.pietanzaToPiatto(pietanza.get());
    }

    @Override
    public List<PiattoDTO> getAllPiatto() {
        List<Pietanza> pietanze = (List<Pietanza>) menuRepository.findAll();
        List<PiattoDTO> piatti = new ArrayList<>();
        for (Pietanza pietanza : pietanze) {
            piatti.add(pietanzaToPiatto.pietanzaToPiatto(pietanza));
        }
        return piatti;
    }

    @Override
    public List<PiattoDTO> getPiattoByType(PiattoDTO.TipologiaPiattoEnum type) {
        Optional<List<Pietanza>> pietanze = Optional.of(menuRepository.findByTipologiaPietanza(type));
        List<PiattoDTO> piatti = new ArrayList<>();
        for (Pietanza pietanza : pietanze.get()) {
            piatti.add(pietanzaToPiatto.pietanzaToPiatto(pietanza));
        }
        return piatti;
    }

    @Override
    public PiattoDTO updatePiatto(PiattoDTO piattoDTO, Long idPiatto) {
        Optional<Pietanza> pietanza = menuRepository.findById(idPiatto);
        if (pietanza.isEmpty()) {
            return null;
        }
        Pietanza pietanzaToUpdate = piattoToPietanza.piattoToPietanza(piattoDTO);
        pietanzaToUpdate.setIdPietanza(idPiatto);
        pietanzaToUpdate = menuRepository.save(pietanzaToUpdate);
        return pietanzaToPiatto.pietanzaToPiatto(pietanzaToUpdate);
    }

    @Override
    public PiattoDTO getPiattoById(Long idPiatto) {
        Optional<Pietanza> pietanza = menuRepository.findById(idPiatto);
        return pietanza.map(value -> pietanzaToPiatto.pietanzaToPiatto(value)).orElse(null);
    }
}
