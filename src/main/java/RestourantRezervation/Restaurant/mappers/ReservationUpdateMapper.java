package RestourantRezervation.Restaurant.mappers;

import RestourantRezervation.Restaurant.dtos.ReservationDto;
import RestourantRezervation.Restaurant.dtos.ReservationUpdateRequestDto;
import RestourantRezervation.Restaurant.entities.Reservation;

public class ReservationUpdateMapper {
    public Reservation toEntity(ReservationUpdateRequestDto dto){
        Reservation reservation = new Reservation();
        reservation.setReservationDate(dto.getReservationDate());
        reservation.setTime(dto.getTime());
        reservation.setRestaurant(dto.getRestaurant());
        return reservation;
    }
    public ReservationUpdateRequestDto toDto(Reservation reservation){
        ReservationUpdateRequestDto dto = new ReservationUpdateRequestDto();
        dto.setReservationDate(reservation.getReservationDate());
        dto.setTime(reservation.getTime());
        dto.setRestaurant(reservation.getRestaurant());
        return dto;
    }
}
