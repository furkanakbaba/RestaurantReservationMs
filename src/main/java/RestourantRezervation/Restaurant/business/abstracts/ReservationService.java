package RestourantRezervation.Restaurant.business.abstracts;

import RestourantRezervation.Restaurant.core.utilities.results.DataResult;
import RestourantRezervation.Restaurant.core.utilities.results.Result;
import RestourantRezervation.Restaurant.dtos.ReservationAddRequestDto;
import RestourantRezervation.Restaurant.dtos.ReservationDto;
import RestourantRezervation.Restaurant.dtos.ReservationUpdateRequestDto;

import java.util.List;

public interface ReservationService {
    public Result add(int customerId,int restaurantId,ReservationAddRequestDto dto);
    public Result update(int id, ReservationUpdateRequestDto dto);
    public Result delete(int id);
    public DataResult<List<ReservationDto>> getAll();
}
