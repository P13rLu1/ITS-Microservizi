package it.apuliadigital.esercizio08esercizioesame.mapper;

import it.apuliadigital.esercizio08esercizioesame.entity.AnimaleEntity;
import it.apuliadigital.esercizio08esercizioesame.server.model.PetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnimaleMapper {

    @Mapping(source = "petId", target = "idAnimale")
    @Mapping(source = "name", target = "nome")
    @Mapping(source = "tag", target = "specie")
    AnimaleEntity petToAnimaleEntity(PetDTO petDTO);

    @Mapping(source = "idAnimale", target = "petId")
    @Mapping(source = "nome", target = "name")
    @Mapping(source = "specie", target = "tag")
    PetDTO animaleEntityToPet(AnimaleEntity animaleEntity);

    @Mapping(source = "petId", target = "idAnimale")
    @Mapping(source = "name", target = "nome")
    @Mapping(source = "tag", target = "specie")
    List<AnimaleEntity> petToAnimaleEntity(List<PetDTO> petDTO);

    @Mapping(source = "idAnimale", target = "petId")
    @Mapping(source = "nome", target = "name")
    @Mapping(source = "specie", target = "tag")
    List<PetDTO> animaleEntityToPet(List<AnimaleEntity> animaleEntity);
}
