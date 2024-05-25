package com.sakak.api.nutrient.domain;

import com.sakak.api.food.domain.Food;
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
    private Long researchYear;
    private Long servingSize;
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
        Long researchYear,
        Long servingSize,
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
            researchYear,
            servingSize,
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
}
