package com.sakak.api.nutrient.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import java.util.stream.Stream;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CalorieTest {

    @ParameterizedTest
    @MethodSource("validCalorie")
    void 칼로리를_정상적으로_생성한다(double calorie) {
        //given when
        Calorie validCalorie = Calorie.from(calorie);

        //then
        assertThat(validCalorie.getKcal()).isEqualTo(BigDecimal.valueOf(calorie));
    }

    @ParameterizedTest
    @MethodSource("invalidCalorie")
    void 칼로리_생성에_실패한다(double calorie) {
        //given when
        ThrowingCallable callable = () -> Calorie.from(calorie);

        //then
        assertThatThrownBy(callable).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> validCalorie() {
        return Stream.of(
            Arguments.of(0),
            Arguments.of(99999999)
        );
    }

    static Stream<Arguments> invalidCalorie() {
        return Stream.of(
            Arguments.of(-1),
            Arguments.of(100000000)
        );
    }

}
