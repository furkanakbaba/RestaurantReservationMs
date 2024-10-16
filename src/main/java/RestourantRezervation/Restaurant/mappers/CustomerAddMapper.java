package RestourantRezervation.Restaurant.mappers;

import RestourantRezervation.Restaurant.dtos.CustomerAddRequestDto;
import RestourantRezervation.Restaurant.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerAddMapper {
        public Customer toEntity(CustomerAddRequestDto dto){
            Customer customer = new Customer();
            customer.setName(dto.getName());
            customer.setEmail(dto.getEmail());
            customer.setSurName(dto.getSurName());
            customer.setPhoneNumber(dto.getPhoneNumber());
            return customer;
        }

        public CustomerAddRequestDto toDto(Customer entity){
            CustomerAddRequestDto dto = new CustomerAddRequestDto();
            dto.setName(entity.getName());
            dto.setEmail(entity.getEmail());
            dto.setSurName(entity.getSurName());
            dto.setPhoneNumber(entity.getPhoneNumber());
            return dto;
        }

}
