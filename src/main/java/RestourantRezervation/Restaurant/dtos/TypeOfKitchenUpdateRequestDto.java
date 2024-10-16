package RestourantRezervation.Restaurant.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TypeOfKitchenUpdateRequestDto {
    @NotNull
    @NotBlank
    private String name;
}
