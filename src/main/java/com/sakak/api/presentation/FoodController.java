package com.sakak.api.presentation;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/foods")
public class FoodController {

    @GetMapping("/nutrients/{food_code}")
    public ResponseEntity<Void> getFoodNutrient(
        @PathVariable("food_code") String foodCode,
        @RequestParam("food_name") String foodName,
        @RequestParam("maker_name") String makerName,
        @RequestParam("research_year") String researchYear
    ) {
        return null;
    }

}
