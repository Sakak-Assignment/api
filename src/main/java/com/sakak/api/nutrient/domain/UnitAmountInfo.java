package com.sakak.api.nutrient.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UnitAmountInfo {

    private static final double MAX_UNIT_AMOUNT = 99999999.0;

    @Column(nullable = false)
    private BigDecimal carbohydrate;

    @Column(nullable = false)
    private BigDecimal protein;

    @Column(nullable = false)
    private BigDecimal province;

    @Column(nullable = false)
    private BigDecimal sugars;

    @Column(nullable = false)
    private BigDecimal salt;

    @Column(nullable = false)
    private BigDecimal cholesterol;

    @Column(nullable = false)
    private BigDecimal saturatedFattyAcids;

    @Column(nullable = false)
    private BigDecimal transFat;

    private UnitAmountInfo(
        BigDecimal carbohydrate,
        BigDecimal protein,
        BigDecimal province,
        BigDecimal sugars,
        BigDecimal salt,
        BigDecimal cholesterol,
        BigDecimal saturatedFattyAcids,
        BigDecimal transFat
    ) {
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.province = province;
        this.sugars = sugars;
        this.salt = salt;
        this.cholesterol = cholesterol;
        this.saturatedFattyAcids = saturatedFattyAcids;
        this.transFat = transFat;
    }

    public static UnitAmountInfo of(
        double carbohydrate,
        double protein,
        double province,
        double sugars,
        double salt,
        double cholesterol,
        double saturatedFattyAcids,
        double transFat
    ) {
        validateUnitAmount(carbohydrate);
        validateUnitAmount(protein);
        validateUnitAmount(province);
        validateUnitAmount(sugars);
        validateUnitAmount(salt);
        validateUnitAmount(cholesterol);
        validateUnitAmount(saturatedFattyAcids);
        validateUnitAmount(transFat);

        return new UnitAmountInfo(
            BigDecimal.valueOf(carbohydrate),
            BigDecimal.valueOf(protein),
            BigDecimal.valueOf(province),
            BigDecimal.valueOf(sugars),
            BigDecimal.valueOf(salt),
            BigDecimal.valueOf(cholesterol),
            BigDecimal.valueOf(saturatedFattyAcids),
            BigDecimal.valueOf(transFat)
        );
    }

    private static void validateUnitAmount(double unitAmount) {
        if (unitAmount < 0 || MAX_UNIT_AMOUNT < unitAmount) {
            throw new IllegalArgumentException("invalid unit amount");
        }
    }

}
