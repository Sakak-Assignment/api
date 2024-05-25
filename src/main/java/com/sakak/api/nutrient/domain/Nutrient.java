package com.sakak.api.nutrient.domain;

import com.sakak.api.food.domain.Food;
import com.sakak.api.nutrient.domain.vo.Calorie;
import com.sakak.api.nutrient.domain.vo.RefName;
import com.sakak.api.nutrient.domain.vo.ResearchYear;
import com.sakak.api.nutrient.domain.vo.ServingSize;
import com.sakak.api.nutrient.domain.vo.UnitAmountGram;
import com.sakak.api.nutrient.domain.vo.UnitAmountMilligram;
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
    private ResearchYear researchYear;
    private ServingSize servingSize;
    private RefName refName;
    private Calorie calorie;
    private UnitAmountGram carbohydrate;
    private UnitAmountGram protein;
    private UnitAmountGram province;
    private UnitAmountGram sugars;
    private UnitAmountMilligram salt;
    private UnitAmountMilligram cholesterol;
    private UnitAmountGram saturatedFattyAcids;
    private UnitAmountGram transFat;

    private Nutrient(
        Long foodId,
        ResearchYear researchYear,
        ServingSize servingSize,
        RefName refName,
        Calorie calorie,
        UnitAmountGram carbohydrate,
        UnitAmountGram protein,
        UnitAmountGram province,
        UnitAmountGram sugars,
        UnitAmountMilligram salt,
        UnitAmountMilligram cholesterol,
        UnitAmountGram saturatedFattyAcids,
        UnitAmountGram transFat
    ) {
        this.foodId = foodId;
        this.researchYear = researchYear;
        this.servingSize = servingSize;
        this.refName = refName;
        this.calorie = calorie;
        this.carbohydrate = carbohydrate;
        this.protein = protein;
        this.province = province;
        this.sugars = sugars;
        this.salt = salt;
        this.cholesterol = cholesterol;
        this.saturatedFattyAcids = saturatedFattyAcids;
        this.transFat = transFat;
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
            UnitAmountGram.from(carbohydrate),
            UnitAmountGram.from(protein),
            UnitAmountGram.from(province),
            UnitAmountGram.from(sugars),
            UnitAmountMilligram.from(salt),
            UnitAmountMilligram.from(cholesterol),
            UnitAmountGram.from(saturatedFattyAcids),
            UnitAmountGram.from(transFat)
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
        return carbohydrate.getGram();
    }

    public BigDecimal getProtein() {
        return protein.getGram();
    }

    public BigDecimal getProvince() {
        return province.getGram();
    }

    public BigDecimal getSugars() {
        return sugars.getGram();
    }

    public BigDecimal getSalt() {
        return salt.getMilligram();
    }

    public BigDecimal getCholesterol() {
        return cholesterol.getMilligram();
    }

    public BigDecimal getSaturatedFattyAcids() {
        return saturatedFattyAcids.getGram();
    }

    public BigDecimal getTransFat() {
        return transFat.getGram();
    }

}
