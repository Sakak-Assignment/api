package com.sakak.api.food;

import com.sakak.api.food.domain.Food;

public class FoodFixture {

    public static Food createFood() {
        return Food.of("foodCode", "foodName", "markerName", "groupName");
    }

}
