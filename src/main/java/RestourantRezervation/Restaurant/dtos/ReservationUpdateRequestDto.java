package RestourantRezervation.Restaurant.dtos;

import RestourantRezervation.Restaurant.entities.Customer;
import RestourantRezervation.Restaurant.entities.Restaurant;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ReservationUpdateRequestDto {
    private int numberOfPeople;
    private LocalDate reservationDate;
    private LocalTime time;
    private Restaurant restaurant;
}
