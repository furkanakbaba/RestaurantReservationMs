package RestourantRezervation.Restaurant.mappers;

import RestourantRezervation.Restaurant.dtos.ReservationDto;
import RestourantRezervation.Restaurant.entities.Reservation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservationMapper {
    public Reservation toEntity(ReservationDto dto){
        Reservation reservation = new Reservation();
        reservation.setReservationId(dto.getId());
        reservation.setReservationDate(dto.getReservationDate());
        reservation.setTime(dto.getTime());
        reservation.setRestaurant(dto.getRestaurant());
        reservation.setNumberOfPeople(dto.getNumberOfPeople());
        reservation.setCustomer(dto.getCustomer());
        return reservation;
    }
    public ReservationDto toDto(Reservation reservation){
        ReservationDto dto = new ReservationDto();
        dto.setId(reservation.getReservationId());
        dto.setReservationDate(reservation.getReservationDate());
        dto.setTime(reservation.getTime());
        dto.setRestaurant(reservation.getRestaurant());
        dto.setNumberOfPeople(reservation.getNumberOfPeople());
        dto.setCustomer(reservation.getCustomer());
        return dto;
    }
    public List<ReservationDto> toDoList(List<Reservation> reservations){
        return reservations.stream().
                map(this::toDto).
                collect(Collectors.toList());
    }
}
