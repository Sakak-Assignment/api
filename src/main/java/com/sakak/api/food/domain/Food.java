package com.sakak.api.food.domain;

import com.sakak.api.food.domain.vo.FoodCode;
import com.sakak.api.food.domain.vo.FoodName;
import com.sakak.api.food.domain.vo.GroupName;
import com.sakak.api.food.domain.vo.MakerName;
import com.sakak.api.nutrient.domain.Nutrient;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
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

    @Embedded
    private GroupName groupName;

    @OneToMany(mappedBy = "food")
    private final List<Nutrient> nutrients = new ArrayList<>();

    private Food(FoodCode foodCode, FoodName foodName, MakerName makerName, GroupName groupName) {
        this.foodCode = foodCode;
        this.foodName = foodName;
        this.makerName = makerName;
        this.groupName = groupName;
    }

    public static Food of(String foodCode, String foodName, String makerName, String groupName) {
        return new Food(
            FoodCode.from(foodCode),
            FoodName.from(foodName),
            MakerName.from(makerName),
            GroupName.from(groupName)
        );
    }

    public String getFoodCode() {
        return foodCode.getCode();
    }

    public String getFoodName() {
        return foodName.getName();
    }

    public String getMakerName() {
        return makerName.getName();
    }

    public String getGroupName() {
        return makerName.getName();
    }

}
