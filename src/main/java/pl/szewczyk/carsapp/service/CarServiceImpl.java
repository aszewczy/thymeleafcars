package pl.szewczyk.carsapp.service;

import org.springframework.stereotype.Service;
import pl.szewczyk.carsapp.model.Car;
import pl.szewczyk.carsapp.model.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CarServiceImpl implements CarService {

    private List<Car> carList = new ArrayList<>();

    public CarServiceImpl(){
        this.carList = new ArrayList<>();
        carList.add(new Car(1L,"Opel","Astra", Color.BLACK));
        carList.add(new Car(2L,"Audi","A5", Color.RED));
        carList.add(new Car(3L,"BMW","e46", Color.BLUE));
    }


    @Override
    public List<Car> getAllCars() {
        return carList;
    }

    @Override
    public Optional<Car> getCarById(long id) {
        return carList.stream().filter(car -> car.getId() == id).findFirst();
    }

    @Override
    public boolean addCar(Car car) {
        return carList.add(car);
    }

    @Override
    public boolean updateCar(Car updateCar) {
        Optional<Car> foundCar = carList.stream().filter(car -> car.getId() == updateCar.getId()).findFirst();

        if(foundCar.isPresent()){
            foundCar.get().setMark(updateCar.getMark());
            foundCar.get().setModel(updateCar.getModel());
            foundCar.get().setColor(updateCar.getColor());
            return true;
        }

        return false;
    }

    @Override
    public boolean deleteCar(long id) {
        Optional<Car> foundCar = carList.stream().filter(car -> car.getId() == id).findFirst();

        if(foundCar.isPresent()){
            carList.remove(foundCar.get());
            return true;
        }

        return  false;
    }
}


