package com.sakak.api.food.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FoodNameTest {

    @ParameterizedTest
    @MethodSource("validFoodName")
    void 식품_이름을_정상적으로_생성한다(String foodName) {
        //given when
        FoodName validFoodName = FoodName.from(foodName);

        //then
        assertThat(validFoodName.getFoodName()).isEqualTo(foodName);
    }

    @ParameterizedTest
    @MethodSource("invalidFoodName")
    void 식품_이름_생성에_실패한다(String foodName) {
        //given when
        ThrowingCallable callable = () -> FoodName.from(foodName);

        //then
        assertThatThrownBy(callable).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> validFoodName() {
        return Stream.of(
            Arguments.of("a"),
            Arguments.of("bb")
        );
    }

    static Stream<Arguments> invalidFoodName() {
        return Stream.of(
            Arguments.of(""),
            Arguments.of((Object) null)
        );
    }

}
