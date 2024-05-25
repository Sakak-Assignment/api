package com.sakak.api.food.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class FoodName {

    @Column(nullable = false)
    private String foodName;

    private FoodName(String foodName) {
        this.foodName = foodName;
    }

    public static FoodName from(String foodName) {
        validateFoodName(foodName);
        return new FoodName(foodName);
    }

    private static void validateFoodName(String foodName) {
        if (Objects.isNull(foodName) || foodName.isEmpty()) {
            throw new IllegalArgumentException("invalid food foodName");
        }
    }

}
