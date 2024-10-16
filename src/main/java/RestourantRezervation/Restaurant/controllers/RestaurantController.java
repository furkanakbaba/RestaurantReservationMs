package RestourantRezervation.Restaurant.controllers;

import RestourantRezervation.Restaurant.business.abstracts.RestaurantService;
import RestourantRezervation.Restaurant.core.utilities.results.DataResult;
import RestourantRezervation.Restaurant.core.utilities.results.Result;
import RestourantRezervation.Restaurant.dtos.RestaurantAddRequestDto;
import RestourantRezervation.Restaurant.dtos.RestaurantDto;
import RestourantRezervation.Restaurant.dtos.RestaurantUpdateRequestDto;
import RestourantRezervation.Restaurant.dtos.TypeOfKitchenDto;
import RestourantRezervation.Restaurant.entities.Restaurant;
import jakarta.servlet.ServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant/")
public class RestaurantController {
    private RestaurantService restaurantService;
    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }
    @PostMapping("add")
    public ResponseEntity<Result> add(@RequestBody RestaurantAddRequestDto dto){
        return ResponseEntity.ok(this.restaurantService.add(dto));
    }

    @GetMapping("getAll")
    public ResponseEntity<DataResult<List<RestaurantDto>>> getAll(){
        DataResult<List<RestaurantDto>> restaurants = restaurantService.getAll();
        return  ResponseEntity.ok(restaurants);

    }
    @PutMapping("update")
    public ResponseEntity<Result> update(@RequestParam int id,@RequestBody RestaurantUpdateRequestDto dto){
        return ResponseEntity.ok(restaurantService.update(id,dto));

    }
    @GetMapping("getWithKitchens")
    public ResponseEntity<DataResult<List<RestaurantDto>>> getWithKitchens(@RequestParam int id){
        DataResult<List<RestaurantDto>> restaurants = restaurantService.getAllByKitchen(id);
        return  ResponseEntity.ok(restaurants);
    }
}
