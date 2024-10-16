package RestourantRezervation.Restaurant.business.concretes;


import RestourantRezervation.Restaurant.business.abstracts.RestaurantService;
import RestourantRezervation.Restaurant.core.utilities.results.*;

import RestourantRezervation.Restaurant.dtos.RestaurantAddRequestDto;
import RestourantRezervation.Restaurant.dtos.RestaurantDto;
import RestourantRezervation.Restaurant.dtos.RestaurantUpdateRequestDto;

import RestourantRezervation.Restaurant.entities.Restaurant;
import RestourantRezervation.Restaurant.entities.TypeOfKitchen;

import RestourantRezervation.Restaurant.mappers.RestaurantAddMapper;
import RestourantRezervation.Restaurant.mappers.RestaurantMapper;
import RestourantRezervation.Restaurant.mappers.RestaurantUpdateMapper;
import RestourantRezervation.Restaurant.repositories.RestaurantRepository;
import RestourantRezervation.Restaurant.repositories.TypeOfKitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class RestaurantImpl implements RestaurantService {

   private RestaurantRepository repository;
    private TypeOfKitchenRepository typeOfKitchenRepository;
    @Autowired
    public RestaurantImpl(RestaurantRepository repository, TypeOfKitchenRepository typeOfKitchenRepository) {
        this.typeOfKitchenRepository=typeOfKitchenRepository;
        this.repository = repository;

    }
    @Override
    public Result add(RestaurantAddRequestDto dto) {
        RestaurantAddMapper mapper=new RestaurantAddMapper();

     dto.setTypeOfKitchen(typeOfKitchenRepository.findAllById(dto.getTypeOfKitchensId()));
        Restaurant restaurant=mapper.toEntity(dto);


        repository.save(restaurant);
        return new SuccessResult("Restaurant added successfully");
    }

    @Override
    public Result update(int id,RestaurantUpdateRequestDto dto) {
        RestaurantUpdateMapper mapper =new RestaurantUpdateMapper();

        Optional<Restaurant>updatedRestaurant=repository.findById(id);
       List<TypeOfKitchen>kitchens =typeOfKitchenRepository.findAll();
        List<String>kitchenNames;
        if(updatedRestaurant.isPresent()){
            updatedRestaurant.get().setRestaurantName(dto.getRestaurantName());
            updatedRestaurant.get().setAddress(dto.getAddress());
            updatedRestaurant.get().setNumberOfPerson(dto.getNumberOfPerson());
            repository.save(updatedRestaurant.get());
            return new SuccessResult("Restaurant updated successfully");
        }
        else {
            return new ErrorResult(false,"Restaurant not found");
        }



    }

    @Override
    public Result delete(int id) {
        repository.deleteById(id);
        return new SuccessResult("Restaurant deleted successfully");
    }

    @Override
    public DataResult<List<RestaurantDto>> getAll() {
        RestaurantMapper mapper = new RestaurantMapper();
        List<Restaurant> restaurants = repository.findAll();
        return new SuccessDataResult<List<RestaurantDto>>
                (mapper.toDoList(restaurants),true,"restaurants listed");

    }

    @Override
    public DataResult<List<RestaurantDto>> getAllByKitchen(int id) {
        RestaurantMapper mapper = new RestaurantMapper();
        List<Restaurant> restaurants = repository.findByKitchens_KitchenId(id);
        return new SuccessDataResult<List<RestaurantDto>>
                (mapper.toDoList(restaurants),true,"restaurants Listed");
    }
}
