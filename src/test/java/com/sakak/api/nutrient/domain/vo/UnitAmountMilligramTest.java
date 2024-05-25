package com.sakak.api.nutrient.domain.vo;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.math.BigDecimal;
import java.util.stream.Stream;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UnitAmountMilligramTest {

    @ParameterizedTest
    @MethodSource("validUnitAmountMilligram")
    void 일회_제공량_gram을_정상적으로_생성한다(double unitAmountMilligram) {
        //given when
        UnitAmountMilligram validUnitAmountMilligram = UnitAmountMilligram.from(
            unitAmountMilligram);

        //then
        assertThat(validUnitAmountMilligram.getMilligram()).isEqualTo(
            BigDecimal.valueOf(unitAmountMilligram));
    }

    @ParameterizedTest
    @MethodSource("invalidUnitAmountMilligram")
    void 일회_제공량_gram_생성에_실패한다(double unitAmountMilligram) {
        //given when
        ThrowingCallable callable = () -> UnitAmountMilligram.from(unitAmountMilligram);

        //then
        assertThatThrownBy(callable).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> validUnitAmountMilligram() {
        return Stream.of(
            Arguments.of(1),
            Arguments.of(100000)
        );
    }

    static Stream<Arguments> invalidUnitAmountMilligram() {
        return Stream.of(
            Arguments.of(-1),
            Arguments.of(100000000)
        );
    }

}
