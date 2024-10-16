package RestourantRezervation.Restaurant.mappers;

import RestourantRezervation.Restaurant.dtos.ReservationAddRequestDto;
import RestourantRezervation.Restaurant.dtos.ReservationDto;
import RestourantRezervation.Restaurant.entities.Reservation;

public class ReservationAddMapper {
    public Reservation toEntity(ReservationAddRequestDto dto){
        Reservation reservation = new Reservation();
        reservation.setReservationDate(dto.getReservationDate());
        reservation.setTime(dto.getTime());
        reservation.setRestaurant(dto.getRestaurant());
        reservation.setNumberOfPeople(dto.getNumberOfPeople());
        reservation.setCustomer(dto.getCustomer());
        return reservation;
    }
    public ReservationAddRequestDto toDto(Reservation reservation){
        ReservationAddRequestDto dto = new ReservationAddRequestDto();
        dto.setReservationDate(reservation.getReservationDate());
        dto.setTime(reservation.getTime());
        dto.setRestaurant(reservation.getRestaurant());
        dto.setNumberOfPeople(reservation.getNumberOfPeople());
        dto.setCustomer(reservation.getCustomer());
        return dto;
    }
}
