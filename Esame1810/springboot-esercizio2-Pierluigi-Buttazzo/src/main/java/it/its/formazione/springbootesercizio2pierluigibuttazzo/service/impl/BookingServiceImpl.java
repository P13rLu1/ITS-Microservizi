package it.its.formazione.springbootesercizio2pierluigibuttazzo.service.impl;

import it.its.formazione.springbootesercizio2pierluigibuttazzo.entity.BookingEntity;
import it.its.formazione.springbootesercizio2pierluigibuttazzo.mapper.BookingMapper;
import it.its.formazione.springbootesercizio2pierluigibuttazzo.repository.BookingRepository;
import it.its.formazione.springbootesercizio2pierluigibuttazzo.server.model.BookingDTO;
import it.its.formazione.springbootesercizio2pierluigibuttazzo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingMapper bookingMapper;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public BookingDTO createBooking(BookingDTO bookingDTO){
        BookingEntity bookingEntity = bookingMapper.daDTOAEntity(bookingDTO);
        bookingEntity = bookingRepository.save(bookingEntity);
        return bookingMapper.daEntityADTO(bookingEntity);
    }

    @Override
    public void deleteBooking(Integer id){
        Optional<BookingEntity> bookingEntity = bookingRepository.findById(id);
        if(bookingEntity.isPresent()){
            bookingRepository.deleteById(id);
        }
    }

    @Override
    public List<BookingDTO> getAllBookings(){
        List<BookingEntity> bookings = (List<BookingEntity>) bookingRepository.findAll();
        List<BookingDTO> bookingsDTO = new ArrayList<>();
        for(BookingEntity booking : bookings){
            bookingsDTO.add(bookingMapper.daEntityADTO(booking));
        }
        return bookingsDTO;
    }

    @Override
    public BookingDTO getBookingById(Integer id){
        Optional<BookingEntity> bookingEntity = bookingRepository.findById(id);
        return bookingEntity.map(entity -> bookingMapper.daEntityADTO(entity)).orElse(null);
    }

    @Override
    public BookingDTO updateBooking(Integer id, BookingDTO bookingDTO){
        Optional<BookingEntity> bookingEntity = bookingRepository.findById(id);
        if(bookingEntity.isEmpty()){
            return null;
        }

        BookingEntity bookingToUpdate = bookingMapper.daDTOAEntity(bookingDTO);
        bookingToUpdate.setId(id);
        bookingToUpdate = bookingRepository.save(bookingToUpdate);
        return bookingMapper.daEntityADTO(bookingToUpdate);
    }
}
