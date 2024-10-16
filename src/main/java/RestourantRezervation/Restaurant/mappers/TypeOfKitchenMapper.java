package RestourantRezervation.Restaurant.mappers;

import RestourantRezervation.Restaurant.dtos.TypeOfKitchenDto;
import RestourantRezervation.Restaurant.entities.TypeOfKitchen;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class TypeOfKitchenMapper {
    public TypeOfKitchen toEntity(TypeOfKitchenDto dto){
     TypeOfKitchen typeOfKitchen = new TypeOfKitchen();
     typeOfKitchen.setName(dto.getName());
     typeOfKitchen.setKitchenId(dto.getId());
     return typeOfKitchen;

    }

    public TypeOfKitchenDto toDto(TypeOfKitchen typeOfKitchen){
        TypeOfKitchenDto dto = new TypeOfKitchenDto();
        dto.setName(typeOfKitchen.getName());
        dto.setId(typeOfKitchen.getKitchenId());
        return dto;
    }

    public List<TypeOfKitchenDto> toDtoList(List<TypeOfKitchen> kitchens){
        return kitchens.stream().map(this::toDto)
                .collect(Collectors.toList());
    }
}
