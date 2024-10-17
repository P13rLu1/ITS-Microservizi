package it.apuliadigital.esercizio08esercizioesame.mapper;

import it.apuliadigital.esercizio08esercizioesame.document.AnimaleDocument;
import it.apuliadigital.esercizio08esercizioesame.entity.AnimaleEntity;
import it.apuliadigital.esercizio08esercizioesame.server.model.PetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnimaleMongoMapper {

    @Mapping(source = "petId", target = "idAnimale")
    @Mapping(source = "name", target = "nome")
    @Mapping(source = "tag", target = "specie")
    AnimaleDocument toAnimaleDocument(PetDTO animaleDTO);

    @Mapping(source = "idAnimale", target = "petId")
    @Mapping(source = "nome", target = "name")
    @Mapping(source = "specie", target = "tag")
    PetDTO animaleDocumentToPet(AnimaleDocument animaleDocument);

    @Mapping(source = "petId", target = "idAnimale")
    @Mapping(source = "name", target = "nome")
    @Mapping(source = "tag", target = "specie")
    List<AnimaleDocument> petToAnimaleDocument(List<PetDTO> petDTO);

    @Mapping(source = "idAnimale", target = "petId")
    @Mapping(source = "nome", target = "name")
    @Mapping(source = "specie", target = "tag")
    List<PetDTO> animaleDocumentToPet(List<AnimaleDocument> animaleDocument);
}
