package RestourantRezervation.Restaurant.controllers;

import RestourantRezervation.Restaurant.business.abstracts.TypeOfKitchenService;
import RestourantRezervation.Restaurant.core.utilities.results.DataResult;
import RestourantRezervation.Restaurant.core.utilities.results.Result;
import RestourantRezervation.Restaurant.core.utilities.results.SuccessDataResult;
import RestourantRezervation.Restaurant.core.utilities.results.SuccessResult;
import RestourantRezervation.Restaurant.dtos.TypeOfKitchenAddRequestDto;
import RestourantRezervation.Restaurant.dtos.TypeOfKitchenDto;
import RestourantRezervation.Restaurant.dtos.TypeOfKitchenUpdateRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequestMapping("/kitchen/")
public class TypeOfKitchenController {
    private TypeOfKitchenService typeOfKitchenService;
    public TypeOfKitchenController(TypeOfKitchenService typeOfKitchenService) {
        this.typeOfKitchenService = typeOfKitchenService;
    }
    @PostMapping("add")
    public ResponseEntity<Result> add (@RequestBody TypeOfKitchenAddRequestDto dto ){
        return  ResponseEntity.ok(typeOfKitchenService.add(dto));

    }
    @GetMapping("getAll")
    public ResponseEntity <DataResult<List<TypeOfKitchenDto>>>getAll(){
        DataResult<List<TypeOfKitchenDto>> kitchenList = typeOfKitchenService.getAll();
        return  ResponseEntity.ok(kitchenList);

    }
    @PutMapping("update")
    public ResponseEntity<Result> update (@RequestBody TypeOfKitchenUpdateRequestDto dto ){
        return  ResponseEntity.ok(typeOfKitchenService.update(dto));
    }
    @DeleteMapping("delete")
    public ResponseEntity<Result>delete(@RequestParam int id){
        return  ResponseEntity.ok(typeOfKitchenService.delete(id));
    }

}
