package com.sakak.api.food.domain.vo;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FoodCodeTest {

    @ParameterizedTest
    @MethodSource("validFoodCode")
    void 식품_코드를_정상적으로_생성한다(String foodCode) {
        //given when
        FoodCode validFoodCode = FoodCode.from(foodCode);

        //then
        assertThat(validFoodCode.getCode()).isEqualTo(foodCode);
    }

    @ParameterizedTest
    @MethodSource("invalidFoodCode")
    void 식품_코드_생성에_실패한다(String foodCode) {
        //given when
        ThrowingCallable callable = () -> FoodCode.from(foodCode);

        //then
        assertThatThrownBy(callable).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> validFoodCode() {
        return Stream.of(
            Arguments.of("a000000000"),
            Arguments.of("b")
        );
    }

    static Stream<Arguments> invalidFoodCode() {
        return Stream.of(
            Arguments.of("0000000000"),
            Arguments.of(""),
            Arguments.of((Object) null)
        );
    }

}
