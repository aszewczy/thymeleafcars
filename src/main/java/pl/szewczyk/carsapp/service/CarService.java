package pl.szewczyk.carsapp.service;

import pl.szewczyk.carsapp.model.Car;

import java.util.List;
import java.util.Optional;

public interface  CarService {

    List<Car> getAllCars();

    Optional<Car> getCarById(long id);

    boolean addCar(Car car);

    boolean updateCar(Car updateCar);

    boolean deleteCar(long id);



}
