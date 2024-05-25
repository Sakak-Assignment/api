package com.sakak.api.food.domain;

import com.sakak.api.food.domain.vo.FoodCode;
import com.sakak.api.food.domain.vo.FoodName;
import com.sakak.api.food.domain.vo.MakerName;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private FoodCode foodCode;

    @Embedded
    private FoodName foodName;

    @Embedded
    private MakerName makerName;

//    @OneToMany(mappedBy = "food")
//    private List<Nutrient> nutrients;

    private Food(FoodCode foodCode, FoodName foodName, MakerName makerName) {
        this.foodCode = foodCode;
        this.foodName = foodName;
        this.makerName = makerName;
    }

    public static Food of(String foodCode, String foodName, String makerName) {
        return new Food(
            FoodCode.from(foodCode),
            FoodName.from(foodName),
            MakerName.from(makerName)
        );
    }

    public String getFoodCode() {
        return foodCode.getCode();
    }

    public String getFoodName() {
        return foodName.getName();
    }

    public String getFoodMakerName() {
        return makerName.getName();
    }

}
