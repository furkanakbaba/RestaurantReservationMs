package RestourantRezervation.Restaurant.mappers;

import RestourantRezervation.Restaurant.dtos.RestaurantAddRequestDto;
import RestourantRezervation.Restaurant.entities.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class RestaurantAddMapper {
    public Restaurant toEntity(RestaurantAddRequestDto dto){
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName(dto.getRestaurantName());
        restaurant.setAddress(dto.getAddress());
        restaurant.setNumberOfPerson(dto.getNumberOfPerson());
        restaurant.setKitchens(dto.getTypeOfKitchen());
        return restaurant;

    }
    public RestaurantAddRequestDto toDto(Restaurant entity){
        RestaurantAddRequestDto dto = new RestaurantAddRequestDto();
        dto.setRestaurantName(entity.getRestaurantName());
        dto.setAddress(entity.getAddress());
        dto.setNumberOfPerson(entity.getNumberOfPerson());
        dto.setTypeOfKitchen(entity.getKitchens());
        return dto;
    }
}
