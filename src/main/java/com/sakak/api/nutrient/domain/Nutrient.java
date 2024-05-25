package com.sakak.api.nutrient.domain;

import com.sakak.api.nutrient.domain.vo.Calorie;
import com.sakak.api.nutrient.domain.vo.RefName;
import com.sakak.api.nutrient.domain.vo.ResearchYear;
import com.sakak.api.nutrient.domain.vo.ServingSize;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Nutrient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long foodId;

    @Embedded
    private ResearchYear researchYear;

    @Embedded
    private ServingSize servingSize;

    @Embedded
    private RefName refName;

    @Embedded
    private Calorie calorie;

    @Embedded
    private UnitAmountInfo unitAmountInfo;

    private Nutrient(
        Long foodId,
        ResearchYear researchYear,
        ServingSize servingSize,
        RefName refName,
        Calorie calorie,
        UnitAmountInfo unitAmountInfo
    ) {
        this.foodId = foodId;
        this.researchYear = researchYear;
        this.servingSize = servingSize;
        this.refName = refName;
        this.calorie = calorie;
        this.unitAmountInfo = unitAmountInfo;
    }

    public static Nutrient of(
        Long foodId,
        long researchYear,
        long servingSize,
        String refName,
        double calorie,
        double carbohydrate,
        double protein,
        double province,
        double sugars,
        double salt,
        double cholesterol,
        double saturatedFattyAcids,
        double transFat
    ) {
        return new Nutrient(
            foodId,
            ResearchYear.from(researchYear),
            ServingSize.from(servingSize),
            RefName.from(refName),
            Calorie.from(calorie),
            UnitAmountInfo.of(
                carbohydrate,
                protein,
                province,
                sugars,
                salt,
                cholesterol,
                saturatedFattyAcids,
                transFat
            )
        );
    }

    public String getRefName() {
        return refName.getName();
    }

    public long getResearchYear() {
        return researchYear.getYear();
    }

    public long getServingSize() {
        return servingSize.getSize();
    }

    public BigDecimal getCalorie() {
        return calorie.getKcal();
    }

    public BigDecimal getCarbohydrate() {
        return unitAmountInfo.getCarbohydrate();
    }

    public BigDecimal getProtein() {
        return unitAmountInfo.getProtein();
    }

    public BigDecimal getProvince() {
        return unitAmountInfo.getProvince();
    }

    public BigDecimal getSugars() {
        return unitAmountInfo.getSugars();
    }

    public BigDecimal getSalt() {
        return unitAmountInfo.getSalt();
    }

    public BigDecimal getCholesterol() {
        return unitAmountInfo.getCholesterol();
    }

    public BigDecimal getSaturatedFattyAcids() {
        return unitAmountInfo.getSaturatedFattyAcids();
    }

    public BigDecimal getTransFat() {
        return unitAmountInfo.getTransFat();
    }

}
