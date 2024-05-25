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
public class FoodCode {

    @Column(nullable = false)
    private String foodCode;

    private FoodCode(String foodCode) {
        this.foodCode = foodCode;
    }

    public static FoodCode from(String foodCode) {
        validateFoodCodeForm(foodCode);
        return new FoodCode(foodCode);
    }

    private static void validateFoodCodeForm(String foodCode) {
        if (Objects.isNull(foodCode)
            || foodCode.isEmpty()
            || !Character.isAlphabetic(foodCode.charAt(0))
        ) {
            throw new IllegalArgumentException("invalid food code form");
        }
    }

}
