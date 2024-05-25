package com.sakak.api.food.presentation;

import com.sakak.api.food.application.FoodService;
import com.sakak.api.food.application.dto.FoodNutrientResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/foods")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/nutrients/{food_code}")
    public ResponseEntity<FoodNutrientResponse> getFoodNutrient(
        @PathVariable("food_code") String foodCode,
        @RequestParam("food_name") String foodName,
        @RequestParam("maker_name") String makerName,
        @RequestParam("research_year") long researchYear
    ) {
        FoodNutrientResponse response = foodService.getFoodNutrient(
            foodCode,
            foodName,
            makerName,
            researchYear
        );
        return ResponseEntity.ok().body(response);
    }

}
