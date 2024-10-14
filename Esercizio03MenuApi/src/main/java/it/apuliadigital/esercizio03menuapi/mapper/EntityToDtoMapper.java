package it.apuliadigital.esercizio03menuapi.mapper;

import it.apuliadigital.esercizio03menuapi.entity.Pietanza;
import it.apuliadigital.esercizio03menuapi.model.PiattoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EntityToDtoMapper {

    @Mapping(source = "idPietanza", target = "idPiatto")
    @Mapping(source = "nomePietanza", target = "nomePiatto")
    @Mapping(source = "tipologiaPietanza", target = "tipologiaPiatto")
    PiattoDTO pietanzaToPiatto(Pietanza pietanza);
}
