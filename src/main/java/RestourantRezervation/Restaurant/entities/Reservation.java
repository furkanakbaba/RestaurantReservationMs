package RestourantRezervation.Restaurant.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"customers","reservation"})

@Table(name="reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reservation_id")
    private int reservationId;

    @Column(name = "number_of_people")
    private int numberOfPeople;

    @Column(name = "reservation_date")
    private LocalDate reservationDate;

    @Column(name="time")
    private LocalTime time;

    @JoinColumn(name = "customerId",nullable = true)
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name="restauranId")
    private Restaurant restaurant;

}
