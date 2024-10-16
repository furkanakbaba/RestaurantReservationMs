package RestourantRezervation.Restaurant.mappers;


import RestourantRezervation.Restaurant.dtos.CustomerUpdateRequestDto;
import RestourantRezervation.Restaurant.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerUpdateMapper {
    public Customer toEntity(CustomerUpdateRequestDto dto){
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setSurName(dto.getSurName());
        customer.setPhoneNumber(dto.getPhoneNumber());
        return customer;
    }

    public CustomerUpdateRequestDto toDto(Customer entity){
        CustomerUpdateRequestDto dto = new CustomerUpdateRequestDto();
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setSurName(entity.getSurName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        return dto;
    }
}
