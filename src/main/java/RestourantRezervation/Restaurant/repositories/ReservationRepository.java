package RestourantRezervation.Restaurant.repositories;

import RestourantRezervation.Restaurant.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
