package RestourantRezervation.Restaurant.repositories;

import RestourantRezervation.Restaurant.entities.Restaurant;
import RestourantRezervation.Restaurant.entities.TypeOfKitchen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
        public List<Restaurant> findByKitchens_KitchenId(int id);
}
