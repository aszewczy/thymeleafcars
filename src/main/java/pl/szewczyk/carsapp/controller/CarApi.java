package pl.szewczyk.carsapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.szewczyk.carsapp.model.Car;
import pl.szewczyk.carsapp.service.CarService;

import java.util.List;
import java.util.Optional;

@Controller
public class CarApi {


    private CarService carService;

    @Autowired
    public CarApi(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping("/car")
    public String getCars(Model model) {
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        return "car";
    }


    @RequestMapping("/add")
    public String addCar(Model model) {
        Car car = new Car();
        model.addAttribute("car", car);
        return "new_car";

    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editCar(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("edit_car");
        Optional<Car> car = carService.getCarById(id);
        Car c = car.get();
        mav.addObject("car", c);
        return mav;
    }

    @RequestMapping("/save")
    public String saveCar(@ModelAttribute("car") Car car) {
        carService.addCar(car);
        return "redirect:/car";
    }

    @RequestMapping("/update")
    public String updateCar(@ModelAttribute("car") Car car) {
        if (carService.updateCar(car)) {
            return "redirect:/car";
        }
        return "redirect:/car";
    }

    @RequestMapping("/delete/{id}")
    public String removeCar(@PathVariable(name = "id") long id) {
        carService.deleteCar(id);
        return "redirect:/car";
    }

}









