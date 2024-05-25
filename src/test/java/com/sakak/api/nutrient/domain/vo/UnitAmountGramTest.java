package com.sakak.api.nutrient.domain.vo;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.math.BigDecimal;
import java.util.stream.Stream;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UnitAmountGramTest {

    @ParameterizedTest
    @MethodSource("validUnitAmountGram")
    void 일회_제공량_gram을_정상적으로_생성한다(double unitAmountGram) {
        //given when
        UnitAmountGram validUnitAmountGram = UnitAmountGram.from(unitAmountGram);

        //then
        assertThat(validUnitAmountGram.getGram()).isEqualTo(BigDecimal.valueOf(unitAmountGram));
    }

    @ParameterizedTest
    @MethodSource("invalidUnitAmountGram")
    void 일회_제공량_gram_생성에_실패한다(double unitAmountGram) {
        //given when
        ThrowingCallable callable = () -> UnitAmountGram.from(unitAmountGram);

        //then
        assertThatThrownBy(callable).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> validUnitAmountGram() {
        return Stream.of(
            Arguments.of(1),
            Arguments.of(100000)
        );
    }

    static Stream<Arguments> invalidUnitAmountGram() {
        return Stream.of(
            Arguments.of(-1),
            Arguments.of(100000000)
        );
    }

}
