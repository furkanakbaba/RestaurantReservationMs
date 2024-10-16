package RestourantRezervation.Restaurant.repositories;

import RestourantRezervation.Restaurant.entities.TypeOfKitchen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public interface TypeOfKitchenRepository extends JpaRepository<TypeOfKitchen, Integer> {

}
