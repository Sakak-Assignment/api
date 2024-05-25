package com.sakak.api.food.application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.sakak.api.DatabaseCleanup;
import com.sakak.api.food.FoodFixture;
import com.sakak.api.food.application.dto.FoodNutrientResponse;
import com.sakak.api.food.domain.Food;
import com.sakak.api.food.domain.FoodRepository;
import com.sakak.api.nutrient.domain.Nutrient;
import com.sakak.api.nutrient.domain.NutrientRepository;
import com.sakak.api.nutrient.domain.vo.NutrientFixture;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FoodServiceTest {

    @Autowired
    private FoodService foodService;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private NutrientRepository nutrientRepository;

    @Autowired
    private DatabaseCleanup databaseCleanup;

    @AfterEach
    public void tearDown() {
        databaseCleanup.execute();
    }

    @Test
    void 식품의_영양소_정보를_조회한다() {
        // given
        Food savedFood = foodRepository.save(FoodFixture.createFood());
        Nutrient savedNutrient = nutrientRepository.save(NutrientFixture.createNutrient(savedFood));

        // when
        FoodNutrientResponse response = foodService.getFoodNutrient(
            savedFood.getFoodCode(),
            savedFood.getFoodName(),
            savedFood.getMakerName(),
            savedNutrient.getResearchYear()
        );

        // then
        assertAll(
            () -> assertThat(savedFood.getFoodCode()).isEqualTo(response.foodCd()),
            () -> assertThat(savedFood.getFoodName()).isEqualTo(response.foodName()),
            () -> assertThat(savedFood.getMakerName()).isEqualTo(response.makerName()),
            () -> assertThat(savedFood.getGroupName()).isEqualTo(response.groupName()),
            () -> assertThat(savedNutrient.getResearchYear()).isEqualTo(response.researchYear()),
            () -> assertThat(savedNutrient.getRefName()).isEqualTo(response.refName()),
            () -> assertThat(savedNutrient.getServingSize()).isEqualTo(response.servingSize()),
            () -> assertThat(savedNutrient.getCalorie()).isCloseTo(response.calorie(),
                Percentage.withPercentage(.00001)),
            () -> assertThat(savedNutrient.getCarbohydrate()).isCloseTo(response.carbohydrate(),
                Percentage.withPercentage(.00001)),
            () -> assertThat(savedNutrient.getProtein()).isCloseTo(response.protein(),
                Percentage.withPercentage(.00001)),
            () -> assertThat(savedNutrient.getProvince()).isCloseTo(response.province(),
                Percentage.withPercentage(.00001)),
            () -> assertThat(savedNutrient.getSugars()).isCloseTo(response.sugars(),
                Percentage.withPercentage(.00001)),
            () -> assertThat(savedNutrient.getSalt()).isCloseTo(response.salt(),
                Percentage.withPercentage(.00001)),
            () -> assertThat(savedNutrient.getCholesterol()).isCloseTo(response.cholesterol(),
                Percentage.withPercentage(.00001)),
            () -> assertThat(savedNutrient.getSaturatedFattyAcids()).isCloseTo(
                response.saturatedFattyAcids(), Percentage.withPercentage(.00001)),
            () -> assertThat(savedNutrient.getTransFat()).isCloseTo(response.transFat(),
                Percentage.withPercentage(.00001))
        );
    }

    @Test
    void 식품이_존재하지_않는_경우_조회에_실패한다() {
        //given when
        ThrowingCallable callable = () -> foodService.getFoodNutrient(
            "D없는코드",
            "asdf",
            "asdf",
            2022
        );

        //then
        assertThatThrownBy(callable).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 영양소가_존재하지_않는_경우_조회에_실패한다() {
        //given
        Food savedFood = foodRepository.save(FoodFixture.createFood());

        //when
        ThrowingCallable callable = () -> foodService.getFoodNutrient(
            savedFood.getFoodCode(),
            savedFood.getFoodName(),
            savedFood.getMakerName(),
            2000
        );

        //then
        assertThatThrownBy(callable).isInstanceOf(IllegalArgumentException.class);
    }

}
