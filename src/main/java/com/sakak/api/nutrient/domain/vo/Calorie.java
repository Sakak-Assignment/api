package com.sakak.api.nutrient.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Calorie {

    private static final double MAX_CALORIE = 99999999.0;

    @Column(nullable = false)
    private BigDecimal kcal;

    private Calorie(BigDecimal kcal) {
        this.kcal = kcal;
    }

    public static Calorie from(double kcal) {
        validateCalorie(kcal);
        return new Calorie(BigDecimal.valueOf(kcal));
    }

    private static void validateCalorie(double kcal) {
        if (kcal < 0 || MAX_CALORIE < kcal) {
            throw new IllegalArgumentException("invalid Calorie");
        }
    }

}
