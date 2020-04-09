package com.adrian.springdata;

import com.adrian.springdata.entities.Car;
import com.adrian.springdata.enums.Color;
import com.adrian.springdata.repositories.CarRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Start {

    private CarRepository carRepository;

    public Start(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
         Car car1 = new Car("Toyota", "Najnowszy", Color.BLUE);
        carRepository.save(car1);

        Car car2 = new Car("Fiat", "F1", Color.BLACK);
        carRepository.save(car2);

        Car car3 = new Car("Opel", "O2", Color.RED);
        carRepository.save(car3);

        // carRepository.deleteById(1L);

        List<Car> cars = carRepository.findAllByColor(Color.BLACK);

        cars.forEach(System.out::println);
    }
}
