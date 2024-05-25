package com.sakak.api.nutrient.domain;

import com.sakak.api.food.domain.Food;
import com.sakak.api.nutrient.domain.vo.RefName;
import com.sakak.api.nutrient.domain.vo.ResearchYear;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;
    private ResearchYear researchYear;
    private Long servingSize;
    private RefName refName;
    private BigDecimal calorie;
    private BigDecimal carbohydrate;
    private BigDecimal protein;
    private BigDecimal province;
    private BigDecimal sugars;
    private BigDecimal salt;
    private BigDecimal cholesterol;
    private BigDecimal saturatedFattyAcids;
    private BigDecimal transFat;

    private Nutrient(
        Food food,
        ResearchYear researchYear,
        Long servingSize,
        RefName refName,
        BigDecimal calorie,
        BigDecimal carbohydrate,
        BigDecimal protein,
        BigDecimal province,
        BigDecimal sugars,
        BigDecimal salt,
        BigDecimal cholesterol,
        BigDecimal saturatedFattyAcids,
        BigDecimal transFat
    ) {
        this.food = food;
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
        Food food,
        Long researchYear,
        Long servingSize,
        String refName,
        BigDecimal calorie,
        BigDecimal carbohydrate,
        BigDecimal protein,
        BigDecimal province,
        BigDecimal sugars,
        BigDecimal salt,
        BigDecimal cholesterol,
        BigDecimal saturatedFattyAcids,
        BigDecimal transFat
    ) {
        return new Nutrient(
            food,
            ResearchYear.from(researchYear),
            servingSize,
            RefName.from(refName),
            calorie,
            carbohydrate,
            protein,
            province,
            sugars,
            salt,
            cholesterol,
            saturatedFattyAcids,
            transFat
        );
    }

    public String getRefName() {
        return refName.getName();
    }

    public Long getResearchYear() {
        return researchYear.getYear();
    }

}
