package com.sakak.api.nutrient.domain.vo;

import com.sakak.api.nutrient.domain.Nutrient;

public class NutrientFixture {

    public static Nutrient createNutrient() {
        return Nutrient.of(
            1L,
            2000L,
            3000L,
            "영양소 조사 출처",
            5000.0,
            6000.0,
            7000.0,
            8000.0,
            9000.0,
            10000.0,
            11000.0,
            12000.0,
            13000.0
        );
    }

}
