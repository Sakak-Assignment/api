package com.sakak.api.food.application.dto;

import com.sakak.api.food.domain.Food;
import com.sakak.api.nutrient.domain.Nutrient;
import java.math.BigDecimal;

public record FoodNutrientResponse(
    Long id,
    String foodCd,
    String GroupName,
    String foodName,
    long researchYear,
    String makerName,
    String refName,
    long servingSize,
    BigDecimal calorie,
    BigDecimal carbohydrate,
    BigDecimal protein,
    BigDecimal province,
    BigDecimal sugars,
    BigDecimal salt,
    BigDecimal cholesterol,
    BigDecimal saturatedFattyAcids,
    BigDecimal transFat
) {

    static FoodNutrientResponse of(Food food, Nutrient nutrient) {
        return new FoodNutrientResponse(
            food.getId(),
            food.getFoodCode(),
            food.getGroupName(),
            food.getFoodName(),
            nutrient.getResearchYear(),
            food.getMakerName(),
            nutrient.getRefName(),
            nutrient.getServingSize(),
            nutrient.getCalorie(),
            nutrient.getCarbohydrate(),
            nutrient.getProtein(),
            nutrient.getProvince(),
            nutrient.getSugars(),
            nutrient.getSalt(),
            nutrient.getCholesterol(),
            nutrient.getSaturatedFattyAcids(),
            nutrient.getTransFat()
        );
    }
}
