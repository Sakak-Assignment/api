package com.sakak.api.nutrient.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RefNameTest {

    @ParameterizedTest
    @MethodSource("validRefName")
    void 성분표_출처를_정상적으로_생성한다(String refName) {
        //given when
        RefName validRefName = RefName.from(refName);

        //then
        assertThat(validRefName.getName()).isEqualTo(refName);
    }

    @ParameterizedTest
    @MethodSource("invalidRefName")
    void 성분표_출처_생성에_실패한다(String refName) {
        //given when
        ThrowingCallable callable = () -> RefName.from(refName);

        //then
        assertThatThrownBy(callable).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> validRefName() {
        return Stream.of(
            Arguments.of("refName")
        );
    }

    static Stream<Arguments> invalidRefName() {
        return Stream.of(
            Arguments.of(""),
            Arguments.of((Object) null)
        );
    }

}
