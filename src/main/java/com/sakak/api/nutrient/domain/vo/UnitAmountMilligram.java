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
public class UnitAmountMilligram {

    private static final double MAX_MILLIGRAM = 99999999.0;

    @Column(nullable = false)
    private BigDecimal milligram;

    private UnitAmountMilligram(BigDecimal milligram) {
        this.milligram = milligram;
    }

    public static UnitAmountMilligram from(double milligram) {
        validateUnitAmountMilligram(milligram);
        return new UnitAmountMilligram(BigDecimal.valueOf(milligram));
    }

    private static void validateUnitAmountMilligram(double unitAmountMilligram) {
        if (unitAmountMilligram < 0 || MAX_MILLIGRAM < unitAmountMilligram) {
            throw new IllegalArgumentException("invalid unit amount milligram");
        }
    }

}
