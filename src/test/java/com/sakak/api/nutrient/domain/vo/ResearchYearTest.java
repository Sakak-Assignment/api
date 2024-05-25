package com.sakak.api.nutrient.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResearchYearTest {

    @ParameterizedTest
    @MethodSource("validResearchYear")
    void 조사_연도를_정상적으로_생성한다(long researchYear) {
        //given when
        ResearchYear validResearchYear = ResearchYear.from(researchYear);

        //then
        assertThat(validResearchYear.getYear()).isEqualTo(researchYear);
    }

    @ParameterizedTest
    @MethodSource("invalidResearchYear")
    void 조사_연도_생성에_실패한다(long researchYear) {
        //given when
        ThrowingCallable callable = () -> ResearchYear.from(researchYear);

        //then
        assertThatThrownBy(callable).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> validResearchYear() {
        return Stream.of(
            Arguments.of(1900),
            Arguments.of(2024)
        );
    }

    static Stream<Arguments> invalidResearchYear() {
        return Stream.of(
            Arguments.of(1899),
            Arguments.of(10000)
        );
    }

}
