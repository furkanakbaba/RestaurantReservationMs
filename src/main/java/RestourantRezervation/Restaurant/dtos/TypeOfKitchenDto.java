package RestourantRezervation.Restaurant.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TypeOfKitchenDto {
    private int id;
    private String name;

}
