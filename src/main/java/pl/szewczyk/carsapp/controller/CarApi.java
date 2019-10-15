package pl.szewczyk.carsapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.szewczyk.carsapp.model.Car;
import pl.szewczyk.carsapp.service.CarService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value ="/cars")
public class CarApi {


    private CarService carService;

    @Autowired
    public CarApi(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getCars() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable long id) {
        Optional<Car> carById = carService.getCarById(id);
        return carById.map(car -> new ResponseEntity<>(car, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/colour/{colour}")
    public ResponseEntity<List<Car>> getCarByColour(@PathVariable String colour) {
        List<Car> carList = carService.getCarsByColor(colour);

        if (!carList.isEmpty()) {
            return new ResponseEntity<>(carList, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping
    ResponseEntity<Car> updateCar(@RequestBody Car car) {
        if (carService.updateCar(car)) {
            return new ResponseEntity<>(car,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity addCar(@RequestBody Car car) {
        if (carService.addCar(car)) {
            return new ResponseEntity(car,HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity removeCar(@PathVariable long id) {
        if (carService.deleteCar(id)) {
            return new ResponseEntity(id,HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
