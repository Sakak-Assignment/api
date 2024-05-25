package com.sakak.api.nutrient.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ServingSizeTest {

    @ParameterizedTest
    @MethodSource("validServingSize")
    void 일회_제공량을_정상적으로_생성한다(long servingSize) {
        //given when
        ServingSize validServingSize = ServingSize.from(servingSize);

        //then
        assertThat(validServingSize.getSize()).isEqualTo(servingSize);
    }

    @ParameterizedTest
    @MethodSource("invalidServingSize")
    void 일회_제공량_생성에_실패한다(long servingSize) {
        //given when
        ThrowingCallable callable = () -> ServingSize.from(servingSize);

        //then
        assertThatThrownBy(callable).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> validServingSize() {
        return Stream.of(
            Arguments.of(1),
            Arguments.of(10000)
        );
    }

    static Stream<Arguments> invalidServingSize() {
        return Stream.of(
            Arguments.of(0),
            Arguments.of(-1)
        );
    }

}
