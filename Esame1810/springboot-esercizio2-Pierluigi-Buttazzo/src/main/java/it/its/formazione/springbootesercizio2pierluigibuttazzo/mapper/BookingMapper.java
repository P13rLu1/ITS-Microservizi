package it.its.formazione.springbootesercizio2pierluigibuttazzo.mapper;

import it.its.formazione.springbootesercizio2pierluigibuttazzo.entity.BookingEntity;
import it.its.formazione.springbootesercizio2pierluigibuttazzo.server.model.BookingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookingMapper {

    @Mapping(source = "guest", target = "guestName")
    BookingDTO daEntityADTO(BookingEntity bookingEntity);

    @Mapping(source = "guestName", target = "guest")
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    BookingEntity daDTOAEntity(BookingDTO bookingDTO);
}
