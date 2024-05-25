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
public class UnitAmountGram {

    private static final double MAX_MILLIGRAM = 99999999.0;

    @Column(nullable = false)
    private BigDecimal gram;

    private UnitAmountGram(BigDecimal gram) {
        this.gram = gram;
    }

    public static UnitAmountGram from(double gram) {
        validateUnitAmountGram(gram);
        return new UnitAmountGram(BigDecimal.valueOf(gram));
    }

    private static void validateUnitAmountGram(double unitAmountGram) {
        if (unitAmountGram < 0 || MAX_MILLIGRAM < unitAmountGram) {
            throw new IllegalArgumentException("invalid unit amount gram");
        }
    }

}
