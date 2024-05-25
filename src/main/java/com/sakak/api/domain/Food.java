package com.sakak.api.domain;

import com.sakak.api.domain.vo.FoodCode;
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

    private FoodCode foodCode;

    private String foodName;

    private String makerName;

//    @OneToMany(mappedBy = "food")
//    private List<Nutrient> nutrients;

    private Food(FoodCode foodCode, String foodName, String makerName) {
        this.foodCode = foodCode;
        this.foodName = foodName;
        this.makerName = makerName;
    }

    public static Food of(String foodCode, String foodName, String makerName) {
        return new Food(FoodCode.from(foodCode), foodName, makerName);
    }

    public String getFoodCode() {
        return foodCode.getCode();
    }

}
