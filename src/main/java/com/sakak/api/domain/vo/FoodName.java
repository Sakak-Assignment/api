package com.sakak.api.domain.vo;

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
    private String name;

    private FoodName(String name) {
        this.name = name;
    }

    public static FoodName from(String name) {
        validateFoodName(name);
        return new FoodName(name);
    }

    private static void validateFoodName(String foodName) {
        if (Objects.isNull(foodName) || foodName.isEmpty()) {
            throw new IllegalArgumentException("invalid food name");
        }
    }

}
