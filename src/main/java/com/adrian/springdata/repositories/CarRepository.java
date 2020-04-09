package com.adrian.springdata.repositories;

import com.adrian.springdata.entities.Car;
import com.adrian.springdata.enums.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByColor(Color color);
}
