package RestourantRezervation.Restaurant.dtos;

import RestourantRezervation.Restaurant.entities.Reservation;
import RestourantRezervation.Restaurant.entities.TypeOfKitchen;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantAddRequestDto {
    @NotBlank
    @NotNull
    private String restaurantName;

    @NotBlank
    @NotNull
    private int numberOfPerson;

    @NotBlank
    @NotNull
    private String address;

    @NotNull
    private List<Integer> typeOfKitchensId;

    @NotBlank
    @NotNull
    private List<TypeOfKitchen> typeOfKitchen;


}
