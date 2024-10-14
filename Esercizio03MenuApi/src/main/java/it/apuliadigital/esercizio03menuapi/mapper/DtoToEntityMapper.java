package it.apuliadigital.esercizio03menuapi.mapper;

import it.apuliadigital.esercizio03menuapi.entity.Pietanza;
import it.apuliadigital.esercizio03menuapi.model.PiattoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DtoToEntityMapper {

    @Mapping(source = "idPiatto", target = "idPietanza")
    @Mapping(source = "nomePiatto", target = "nomePietanza")
    @Mapping(source = "tipologiaPiatto", target = "tipologiaPietanza")
    @Mapping(target = "fileFoto", ignore = true)
    @Mapping(target = "prezzoProduzione", ignore = true)
    Pietanza piattoToPietanza(PiattoDTO piatto);
}
