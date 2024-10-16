package RestourantRezervation.Restaurant.mappers;

import RestourantRezervation.Restaurant.dtos.CustomerDto;
import RestourantRezervation.Restaurant.entities.Customer;
import RestourantRezervation.Restaurant.entities.Reservation;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    public Customer  toEntity(CustomerDto dto){
        Customer customer = new Customer();
        customer.setCustomerId(dto.getId());
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setSurName(dto.getSurName());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setReservations(dto.getReservations());
        return customer;
    }

    public CustomerDto toDto(Customer entity){
        CustomerDto dto = new CustomerDto();
        dto.setId(entity.getCustomerId());
        dto.setName(entity.getName());
        dto.setEmail(entity.getEmail());
        dto.setSurName(entity.getSurName());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setReservations(entity.getReservations());
        return dto;
    }

    public List<CustomerDto> toDoList(List<Customer>books){
        return books.stream().
                map(this::toDto)
                .collect(Collectors.toList());
    }

}
