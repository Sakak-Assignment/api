package com.sakak.api.food.application;

import com.sakak.api.food.application.dto.FoodNutrientResponse;
import com.sakak.api.food.domain.Food;
import com.sakak.api.food.domain.FoodRepository;
import com.sakak.api.nutrient.domain.Nutrient;
import com.sakak.api.nutrient.domain.NutrientRepository;
import org.springframework.stereotype.Service;

@Service
public class FoodService {

    private final FoodRepository foodRepository;
    private final NutrientRepository nutrientRepository;

    public FoodService(FoodRepository foodRepository, NutrientRepository nutrientRepository) {
        this.foodRepository = foodRepository;
        this.nutrientRepository = nutrientRepository;
    }

    public FoodNutrientResponse getFoodNutrient(
        String foodCode,
        String foodName,
        String makerName,
        long researchYear
    ) {
        Food food = foodRepository.findByFoodCodeAndFoodNameAndMakerName(
            foodCode,
            foodName,
            makerName
        ).orElseThrow(() -> new IllegalArgumentException("해당하는 음식에 대한 정보를 찾을 수 없습니다."));
        Nutrient nutrient = nutrientRepository.findByFoodIdAndResearchYear(
            food.getId(),
            researchYear
        ).orElseThrow(() -> new IllegalArgumentException("해당하는 음식의 영양소 정보를 찾을 수 없습니다."));

        return FoodNutrientResponse.of(food, nutrient);
    }

}
