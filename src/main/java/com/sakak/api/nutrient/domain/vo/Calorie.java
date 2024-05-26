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
    private BigDecimal calorie;

    private Calorie(BigDecimal calorie) {
        this.calorie = calorie;
    }

    public static Calorie from(double calorie) {
        validateCalorie(calorie);
        return new Calorie(BigDecimal.valueOf(calorie));
    }

    private static void validateCalorie(double calorie) {
        if (calorie < 0 || MAX_CALORIE < calorie) {
            throw new IllegalArgumentException("invalid Calorie");
        }
    }

}
