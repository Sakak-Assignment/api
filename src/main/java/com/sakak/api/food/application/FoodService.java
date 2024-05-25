package com.sakak.api.food.application;

import com.sakak.api.food.application.dto.FoodNutrientResponse;
import com.sakak.api.food.domain.Food;
import com.sakak.api.food.domain.FoodRepository;
import com.sakak.api.food.domain.vo.FoodCode;
import com.sakak.api.food.domain.vo.FoodName;
import com.sakak.api.food.domain.vo.MakerName;
import com.sakak.api.nutrient.domain.Nutrient;
import com.sakak.api.nutrient.domain.NutrientRepository;
import com.sakak.api.nutrient.domain.vo.ResearchYear;
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
            FoodCode.from(foodCode),
            FoodName.from(foodName),
            MakerName.from(makerName)
        ).orElseThrow(() -> new IllegalArgumentException("해당하는 음식에 대한 정보를 찾을 수 없습니다."));
        Nutrient nutrient = nutrientRepository.findByFoodIdAndResearchYear(
            food.getId(),
            ResearchYear.from(researchYear)
        ).orElseThrow(() -> new IllegalArgumentException("해당하는 음식의 영양소 정보를 찾을 수 없습니다."));

        return FoodNutrientResponse.of(food, nutrient);
    }

}
