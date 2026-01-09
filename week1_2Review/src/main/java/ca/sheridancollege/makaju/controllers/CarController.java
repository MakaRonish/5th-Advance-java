package ca.sheridancollege.makaju.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.makaju.beans.Car;

@Controller
public class CarController {
	
	public static ArrayList<Car> cars = new ArrayList<Car>();
	
	@GetMapping("/add")
	public String goAddCarPAge(Model model) {
		model.addAttribute("car", new Car());
		return "addCar.html";
	}
	
	@PostMapping("/add")
	public String processAddCarPAge(
			@ModelAttribute Car car
//			@RequestParam String make,
//			@RequestParam String model,
//			@RequestParam int year,
//			@RequestParam double mileage,
//			@RequestParam(required=false, defaultValue="false") boolean hybrid
			) {
		
	
//	car.setMake(make);
//	car.setModel(model);
//	car.setYear(year);
//	car.setMileage(mileage);
//	car.setHybrid(hybrid);
		cars.add(car);
		System.out.println(cars);
	
		return "redirect:/add";
	}
	
	@GetMapping("/view")
	public String ViewCars(Model model) {
		model.addAttribute("cars",cars);
		return "viewCars.html";
		
	}
}
