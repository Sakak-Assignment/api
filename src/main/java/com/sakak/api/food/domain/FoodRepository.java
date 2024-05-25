package com.sakak.api.food.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

    Optional<Food> findByFoodCodeAndFoodNameAndMakerName(
        String foodCode,
        String foodName,
        String makerName
    );

}
