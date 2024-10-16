package RestourantRezervation.Restaurant.dtos;

import RestourantRezervation.Restaurant.entities.TypeOfKitchen;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantDto {

    private int restaurantId;
    private String restaurantName;
    private String address;
    private Integer numberOfPerson;

    private List<TypeOfKitchen> typeOfKitchens;




}
