package RestourantRezervation.Restaurant.mappers;

import RestourantRezervation.Restaurant.dtos.TypeOfKitchenAddRequestDto;
import RestourantRezervation.Restaurant.entities.TypeOfKitchen;
import org.springframework.stereotype.Component;

@Component
public class TypeOfKitchenAddMapper {
    public TypeOfKitchen toEntity(TypeOfKitchenAddRequestDto dto){
        TypeOfKitchen typeOfKitchen = new TypeOfKitchen();
        typeOfKitchen.setName(dto.getName());
        return typeOfKitchen;
    }

    public TypeOfKitchenAddRequestDto toDto(TypeOfKitchen entity){
        TypeOfKitchenAddRequestDto dto =new TypeOfKitchenAddRequestDto();
        dto.setName(entity.getName());
        return dto;
    }
}
