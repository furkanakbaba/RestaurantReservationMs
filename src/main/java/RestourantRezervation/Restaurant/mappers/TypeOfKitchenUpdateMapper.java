package RestourantRezervation.Restaurant.mappers;

import RestourantRezervation.Restaurant.dtos.TypeOfKitchenUpdateRequestDto;
import RestourantRezervation.Restaurant.entities.TypeOfKitchen;
import org.springframework.stereotype.Component;

@Component
public class TypeOfKitchenUpdateMapper {
    public TypeOfKitchen toEntity(TypeOfKitchenUpdateRequestDto dto){
        TypeOfKitchen kitchen = new TypeOfKitchen();
        kitchen.setName(dto.getName());
        return kitchen;
    }
    public TypeOfKitchenUpdateRequestDto toDto(TypeOfKitchen kitchen){
        TypeOfKitchenUpdateRequestDto dto = new TypeOfKitchenUpdateRequestDto();
        dto.setName(kitchen.getName());
        return dto;
    }
}
