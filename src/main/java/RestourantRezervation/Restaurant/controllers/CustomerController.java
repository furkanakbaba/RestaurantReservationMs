package RestourantRezervation.Restaurant.controllers;

import RestourantRezervation.Restaurant.business.abstracts.CustomerService;
import RestourantRezervation.Restaurant.core.utilities.results.DataResult;
import RestourantRezervation.Restaurant.core.utilities.results.Result;

import RestourantRezervation.Restaurant.dtos.CustomerAddRequestDto;
import RestourantRezervation.Restaurant.dtos.CustomerDto;
import RestourantRezervation.Restaurant.dtos.CustomerUpdateRequestDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }
    @PostMapping("add")
    public ResponseEntity<Result> add(@RequestBody CustomerAddRequestDto dto) {
        return  ResponseEntity.ok(customerService.add(dto));
    }
    @GetMapping("getAll")
    public ResponseEntity<DataResult<List<CustomerDto>>>getAll(){
        return ResponseEntity.ok(customerService.getAll());
    }
    @DeleteMapping("delete")
    public ResponseEntity<Result> delete(@RequestParam int id) {
        return  ResponseEntity.ok(customerService.delete(id));
    }
    @PutMapping("update")
    public ResponseEntity<Result> update(@RequestParam int id, @RequestBody CustomerUpdateRequestDto dto) {
        return ResponseEntity.ok(customerService.update(id,dto));
    }
}
