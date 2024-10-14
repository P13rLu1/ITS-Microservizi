package it.apuliadigital.esercizio03menuapi.service;

import it.apuliadigital.esercizio03menuapi.model.PiattoDTO;

import java.util.List;

public interface MenuService {

    PiattoDTO createPiatto(PiattoDTO piattoDTO);

    PiattoDTO deletePiatto(Long idPiatto);

    List<PiattoDTO> getAllPiatto();

    List<PiattoDTO> getPiattoByType(PiattoDTO.TipologiaPiattoEnum type);

    PiattoDTO updatePiatto(PiattoDTO piattoDTO, Long idPiatto);

    PiattoDTO getPiattoById(Long idPiatto);
}
