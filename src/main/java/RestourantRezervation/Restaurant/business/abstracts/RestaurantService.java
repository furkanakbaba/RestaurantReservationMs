package RestourantRezervation.Restaurant.business.abstracts;

import RestourantRezervation.Restaurant.core.utilities.results.DataResult;
import RestourantRezervation.Restaurant.core.utilities.results.Result;
import RestourantRezervation.Restaurant.dtos.RestaurantAddRequestDto;
import RestourantRezervation.Restaurant.dtos.RestaurantDto;
import RestourantRezervation.Restaurant.dtos.RestaurantUpdateRequestDto;

import java.util.List;

public interface RestaurantService {
    public Result add(RestaurantAddRequestDto dto);
    public Result update(int id,RestaurantUpdateRequestDto dto);
    public Result delete(int id);
    public DataResult<List<RestaurantDto>> getAll();
    public DataResult<List<RestaurantDto>> getAllByKitchen(int id);
}
