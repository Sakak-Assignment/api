package com.sakak.api.food.application.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.sakak.api.food.domain.Food;
import com.sakak.api.nutrient.domain.Nutrient;
import java.math.BigDecimal;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record FoodNutrientResponse(
    Long id,
    String foodCd,
    String groupName,
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

    public static FoodNutrientResponse of(Food food, Nutrient nutrient) {
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
