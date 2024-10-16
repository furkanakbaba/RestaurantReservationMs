package RestourantRezervation.Restaurant.dtos;

import RestourantRezervation.Restaurant.entities.Customer;
import RestourantRezervation.Restaurant.entities.Restaurant;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Data
public class ReservationDto {
    private int id;
    private int numberOfPeople;
    private LocalDate reservationDate;
    private LocalTime time;
    private Customer customer;
    private Restaurant restaurant;


}
