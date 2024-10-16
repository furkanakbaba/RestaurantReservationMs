package RestourantRezervation.Restaurant.business.abstracts;

import RestourantRezervation.Restaurant.core.utilities.results.DataResult;
import RestourantRezervation.Restaurant.core.utilities.results.Result;
import RestourantRezervation.Restaurant.dtos.TypeOfKitchenAddRequestDto;
import RestourantRezervation.Restaurant.dtos.TypeOfKitchenDto;
import RestourantRezervation.Restaurant.dtos.TypeOfKitchenUpdateRequestDto;

import java.util.List;

public interface TypeOfKitchenService {
    Result add(TypeOfKitchenAddRequestDto dto);
    Result update(TypeOfKitchenUpdateRequestDto dto);
    Result delete(int id);
    DataResult<List<TypeOfKitchenDto>> getAll();
}
