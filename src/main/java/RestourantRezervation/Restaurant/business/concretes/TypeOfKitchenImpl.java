package RestourantRezervation.Restaurant.business.concretes;

import RestourantRezervation.Restaurant.business.abstracts.TypeOfKitchenService;
import RestourantRezervation.Restaurant.core.utilities.results.DataResult;
import RestourantRezervation.Restaurant.core.utilities.results.Result;
import RestourantRezervation.Restaurant.core.utilities.results.SuccessDataResult;
import RestourantRezervation.Restaurant.core.utilities.results.SuccessResult;
import RestourantRezervation.Restaurant.dtos.TypeOfKitchenAddRequestDto;
import RestourantRezervation.Restaurant.dtos.TypeOfKitchenDto;
import RestourantRezervation.Restaurant.dtos.TypeOfKitchenUpdateRequestDto;
import RestourantRezervation.Restaurant.entities.TypeOfKitchen;
import RestourantRezervation.Restaurant.mappers.TypeOfKitchenMapper;
import RestourantRezervation.Restaurant.mappers.TypeOfKitchenAddMapper;
import RestourantRezervation.Restaurant.mappers.TypeOfKitchenUpdateMapper;
import RestourantRezervation.Restaurant.repositories.TypeOfKitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfKitchenImpl implements TypeOfKitchenService {

    private TypeOfKitchenRepository repository;
    @Autowired
    public TypeOfKitchenImpl(TypeOfKitchenRepository repository) {
        this.repository = repository;
    }
    @Override
    public Result add(TypeOfKitchenAddRequestDto dto) {
        TypeOfKitchenAddMapper mapper = new TypeOfKitchenAddMapper();
        TypeOfKitchen typeOfKitchen=mapper.toEntity(dto);
        repository.save(typeOfKitchen);
        return new SuccessResult("Kitchen added successfully");


    }

    @Override
    public Result update(TypeOfKitchenUpdateRequestDto dto) {
        TypeOfKitchenUpdateMapper mapper = new TypeOfKitchenUpdateMapper();
        TypeOfKitchen kitchen=mapper.toEntity(dto);
        repository.save(kitchen);
        return new SuccessResult("Kitchen updated successfully");
    }

    @Override
    public Result delete(int id) {

     repository.deleteById(id);
     return new SuccessResult("Kitchen deleted successfully");
    }

    @Override
    public DataResult<List<TypeOfKitchenDto>> getAll() {
        TypeOfKitchenMapper mapper = new TypeOfKitchenMapper();
        List<TypeOfKitchen> kitchens=this.repository.findAll();

      return new  SuccessDataResult<List<TypeOfKitchenDto>>(mapper.toDtoList(kitchens),true,"Data Listelendi");
    }
}
