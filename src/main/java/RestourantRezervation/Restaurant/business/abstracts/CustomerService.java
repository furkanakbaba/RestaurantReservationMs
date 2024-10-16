package RestourantRezervation.Restaurant.business.abstracts;

import RestourantRezervation.Restaurant.core.utilities.results.DataResult;
import RestourantRezervation.Restaurant.core.utilities.results.Result;
import RestourantRezervation.Restaurant.dtos.CustomerAddRequestDto;
import RestourantRezervation.Restaurant.dtos.CustomerDto;
import RestourantRezervation.Restaurant.dtos.CustomerUpdateRequestDto;
import RestourantRezervation.Restaurant.entities.Customer;
import RestourantRezervation.Restaurant.entities.Reservation;

import java.util.List;

public interface CustomerService {
public Result add(CustomerAddRequestDto dto);
public Result delete(int id);
public  Result update(int id,CustomerUpdateRequestDto dto);
public DataResult<List<CustomerDto>> getAll();

}
