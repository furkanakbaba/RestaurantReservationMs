package RestourantRezervation.Restaurant.controllers;

import RestourantRezervation.Restaurant.business.abstracts.ReservationService;
import RestourantRezervation.Restaurant.core.utilities.results.DataResult;
import RestourantRezervation.Restaurant.core.utilities.results.Result;
import RestourantRezervation.Restaurant.core.utilities.results.SuccessResult;
import RestourantRezervation.Restaurant.dtos.ReservationAddRequestDto;
import RestourantRezervation.Restaurant.dtos.ReservationDto;
import RestourantRezervation.Restaurant.dtos.ReservationUpdateRequestDto;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation/")
public class ReservationController {
    private ReservationService reservationService;
    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @PostMapping("add")
    public ResponseEntity<Result> add(@RequestParam int customerId, @RequestParam int restaurantId, @RequestBody ReservationAddRequestDto dto){
        return ResponseEntity.ok(this.reservationService.add(customerId,restaurantId,dto));
    }
    @GetMapping("getAll")
    public ResponseEntity<DataResult<List<ReservationDto>>> getAll(){
        return ResponseEntity.ok(this.reservationService.getAll());
    }
    @DeleteMapping("delete")
    public ResponseEntity<Result> delete(@RequestParam int id){
        return ResponseEntity.ok(reservationService.delete(id));
    }
    @PutMapping("update")
    public ResponseEntity<Result> update(@RequestParam int id,  @RequestBody ReservationUpdateRequestDto dto){
        return ResponseEntity.ok(this.reservationService.update(id,dto));
    }
}