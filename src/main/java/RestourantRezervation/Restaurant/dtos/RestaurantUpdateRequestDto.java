package RestourantRezervation.Restaurant.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RestaurantUpdateRequestDto {
    @NotBlank
    @NotNull
    private String restaurantName;

    @NotBlank
    @NotNull
    private int numberOfPerson;

    @NotBlank
    @NotNull
    private String address;

}
