package RestourantRezervation.Restaurant.mappers;

import RestourantRezervation.Restaurant.dtos.RestaurantUpdateRequestDto;
import RestourantRezervation.Restaurant.entities.Restaurant;
import org.springframework.stereotype.Component;

@Component
public class RestaurantUpdateMapper {
    public Restaurant toEntity(RestaurantUpdateRequestDto dto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setNumberOfPerson(dto.getNumberOfPerson());
        restaurant.setAddress(dto.getAddress());
        restaurant.setRestaurantName(dto.getRestaurantName());
        return restaurant;

    }
    public RestaurantUpdateRequestDto toDto(Restaurant restaurant) {
        RestaurantUpdateRequestDto restaurantUpdateRequestDto = new RestaurantUpdateRequestDto();
        restaurantUpdateRequestDto.setNumberOfPerson(restaurant.getNumberOfPerson());
        restaurantUpdateRequestDto.setAddress(restaurant.getAddress());
        restaurantUpdateRequestDto.setRestaurantName(restaurant.getRestaurantName());
        return restaurantUpdateRequestDto;
    }
}
