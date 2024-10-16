package RestourantRezervation.Restaurant.business.concretes;

import RestourantRezervation.Restaurant.business.abstracts.ReservationService;
import RestourantRezervation.Restaurant.core.utilities.results.*;
import RestourantRezervation.Restaurant.dtos.ReservationAddRequestDto;
import RestourantRezervation.Restaurant.dtos.ReservationDto;
import RestourantRezervation.Restaurant.dtos.ReservationUpdateRequestDto;
import RestourantRezervation.Restaurant.entities.Customer;
import RestourantRezervation.Restaurant.entities.Reservation;
import RestourantRezervation.Restaurant.entities.Restaurant;
import RestourantRezervation.Restaurant.mappers.ReservationAddMapper;
import RestourantRezervation.Restaurant.mappers.ReservationMapper;
import RestourantRezervation.Restaurant.mappers.RestaurantUpdateMapper;
import RestourantRezervation.Restaurant.repositories.CustomerRepository;
import RestourantRezervation.Restaurant.repositories.ReservationRepository;
import RestourantRezervation.Restaurant.repositories.RestaurantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import javax.naming.TimeLimitExceededException;
import java.util.List;
import java.util.Optional;
@Service
public class ReservationImpl implements ReservationService {
    ReservationRepository repository;
    RestaurantRepository restaurantRepository;
    CustomerRepository customerRepository;
    public ReservationImpl(ReservationRepository repository, RestaurantRepository restaurantRepository,CustomerRepository customerRepository) {
        this.repository = repository;
        this.restaurantRepository = restaurantRepository;
        this.customerRepository = customerRepository;
    }
    @Override
    public Result add(int customerId,int restaurantId,ReservationAddRequestDto dto) {
        ReservationAddMapper mapper = new ReservationAddMapper();
        Optional<Restaurant> restaurantOpt = restaurantRepository.findById(restaurantId);
        if (restaurantOpt.isPresent()) {
            dto.setRestaurant(restaurantOpt.get());
        }

        else {
            // Hata fırlatabilir veya uygun bir işlem yapılır
            return new ErrorResult(false,"Restaurant not found with id: " + restaurantId);
        }

        Optional<Customer> customerOpt = customerRepository.findById(customerId);
        if (customerOpt.isPresent()) {
            dto.setCustomer(customerOpt.get());
        }

        else{
            return new ErrorResult(false,"Customer not found id " + customerId);
        }


        Reservation reservation = mapper.toEntity(dto);

        for (Reservation r : customerOpt.get().getReservations()){
            if (r.getTime()==reservation.getTime()){
                return new ErrorResult(false,"You have a another reservation in this time");
            }
        }


        Restaurant restaurant=reservation.getRestaurant();
        if (restaurant.getNumberOfPerson()<reservation.getNumberOfPeople())
        {
            return  new ErrorResult(false,"restaurant kapasitesi uygun değil " );
        }

        customerOpt.get().setReservations(dto.getCustomer().getReservations());
        customerRepository.save(customerOpt.get());

        restaurant.setNumberOfPerson(restaurant.getNumberOfPerson()-dto.getNumberOfPeople());

        restaurantRepository.save(restaurant);

        repository.save(reservation);
        return new SuccessResult("reservation succesfully added");

    }
    @Override
    public Result update(int id,ReservationUpdateRequestDto dto) {
        Optional<Reservation> reservationOpt = repository.findById(id);
        RestaurantUpdateMapper mapper=new RestaurantUpdateMapper();
        if (reservationOpt.isPresent()) {
          reservationOpt.get().setNumberOfPeople(dto.getNumberOfPeople());
          reservationOpt.get().setTime(dto.getTime());
          reservationOpt.get().setRestaurant(dto.getRestaurant());
          reservationOpt.get().setReservationDate(dto.getReservationDate());
          repository.save(reservationOpt.get());
          return new SuccessResult("reservation succesfully updated");
        }
        return new ErrorResult(false,"Reservation not found with id: " + id);
    }

    @Override
    public Result delete(int id) {
        Optional<Reservation> reservation =repository.findById(id);
        int restaurantId= reservation.get().getRestaurant().getRestaurantId();
        Optional<Restaurant>restaurant=restaurantRepository.findById(restaurantId);
        restaurant.get().setNumberOfPerson(reservation.get().
                getNumberOfPeople()+restaurant.get().getNumberOfPerson());
        restaurant.get().getReservations().remove(reservation.get());


       restaurantRepository.save(restaurant.get());
       repository.delete(reservation.get());
       return new SuccessResult("reservation succesfully deleted");
    }

    @Override
    public DataResult<List<ReservationDto>> getAll() {
        ReservationMapper mapper=new ReservationMapper();
        List<Reservation> reservations=repository.findAll();

        return new SuccessDataResult<List<ReservationDto>>
                (mapper.toDoList(reservations),true,"Reservation Listed");
    }
}
