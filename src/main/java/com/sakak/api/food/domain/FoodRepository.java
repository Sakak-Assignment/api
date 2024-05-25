package com.sakak.api.food.domain;

import com.sakak.api.food.domain.vo.FoodCode;
import com.sakak.api.food.domain.vo.FoodName;
import com.sakak.api.food.domain.vo.MakerName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

    Optional<Food> findByFoodCodeAndFoodNameAndMakerName(
        FoodCode foodCode,
        FoodName foodName,
        MakerName makerName
    );

}
