package RestourantRezervation.Restaurant.mappers;

import RestourantRezervation.Restaurant.dtos.CustomerDto;
import RestourantRezervation.Restaurant.dtos.RestaurantDto;
import RestourantRezervation.Restaurant.entities.Customer;
import RestourantRezervation.Restaurant.entities.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestaurantMapper {
    public Restaurant  toEntity(RestaurantDto dto){
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(dto.getRestaurantId());
        restaurant.setRestaurantName(dto.getRestaurantName());
        restaurant.setAddress(dto.getAddress());
        restaurant.setNumberOfPerson(dto.getNumberOfPerson());
        restaurant.setKitchens(dto.getTypeOfKitchens());
        return restaurant;
    }

    public RestaurantDto toDto(Restaurant entity){
        RestaurantDto restaurantDto = new RestaurantDto();
        restaurantDto.setRestaurantId(entity.getRestaurantId());
        restaurantDto.setRestaurantName(entity.getRestaurantName());
        restaurantDto.setAddress(entity.getAddress());
        restaurantDto.setNumberOfPerson(entity.getNumberOfPerson());
        restaurantDto.setTypeOfKitchens(entity.getKitchens());
        return restaurantDto;
    }


    public List<RestaurantDto> toDoList(List<Restaurant>books){
        return books.stream().
                map(this::toDto)
                .collect(Collectors.toList());
    }
}
