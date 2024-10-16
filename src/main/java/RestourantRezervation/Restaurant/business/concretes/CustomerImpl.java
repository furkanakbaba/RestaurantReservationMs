package RestourantRezervation.Restaurant.business.concretes;

import RestourantRezervation.Restaurant.business.abstracts.CustomerService;
import RestourantRezervation.Restaurant.core.utilities.results.*;
import RestourantRezervation.Restaurant.dtos.CustomerAddRequestDto;
import RestourantRezervation.Restaurant.dtos.CustomerDto;
import RestourantRezervation.Restaurant.dtos.CustomerUpdateRequestDto;
import RestourantRezervation.Restaurant.entities.Customer;
import RestourantRezervation.Restaurant.entities.Reservation;
import RestourantRezervation.Restaurant.mappers.CustomerAddMapper;
import RestourantRezervation.Restaurant.mappers.CustomerMapper;
import RestourantRezervation.Restaurant.mappers.CustomerUpdateMapper;
import RestourantRezervation.Restaurant.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerImpl implements CustomerService {
    private CustomerRepository customerRepository;
    @Autowired
    public CustomerImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public Result add(CustomerAddRequestDto dto) {
        CustomerAddMapper mapper = new CustomerAddMapper();
        Customer customer = mapper.toEntity(dto);
        customerRepository.save(customer);
        return new SuccessResult("Customer added successfully");


    }

    @Override
    public Result delete(int id) {
    customerRepository.deleteById(id);
        return new SuccessResult("Customer deleted successfully");
    }

    @Override
    public Result update(int id,CustomerUpdateRequestDto dto) {
       Optional<Customer> updatedCustomer= customerRepository.findById(id);
       if(updatedCustomer.isPresent()) {
           CustomerUpdateMapper mapper = new CustomerUpdateMapper();
           Customer customer = mapper.toEntity(dto);
           updatedCustomer.get().setName(customer.getName());
           updatedCustomer.get().setEmail(customer.getEmail());
           updatedCustomer.get().setSurName(customer.getSurName());
           updatedCustomer.get().setPhoneNumber(customer.getPhoneNumber());
           customerRepository.save(updatedCustomer.get());

           return new SuccessResult("Customer updated successfully");

       }

        return new ErrorResult(false,"Customer not found");
    }

    @Override
    public DataResult<List<CustomerDto>> getAll() {
        CustomerMapper mapper = new CustomerMapper();
        List<Customer> customers = customerRepository.findAll();
        return new SuccessDataResult<List<CustomerDto>>
                (mapper.toDoList(customers),true,"Müşteriler listelendi");

    }


}
