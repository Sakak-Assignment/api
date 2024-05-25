package com.sakak.api.food.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.sakak.api.domain.vo.FoodCode;
import com.sakak.api.domain.vo.MakerName;
import java.util.stream.Stream;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MakerNameTest {

    @ParameterizedTest
    @MethodSource("validMakerName")
    void 지역_제조사명을_정상적으로_생성한다(String makerName) {
        //given when
        MakerName validMakerName = MakerName.from(makerName);

        //then
        assertThat(validMakerName.getName()).isEqualTo(makerName);
    }

    @ParameterizedTest
    @MethodSource("invalidMakerName")
    void 지역_제조사명_생성에_실패한다(String makerName) {
        //given when
        ThrowingCallable callable = () -> MakerName.from(makerName);

        //then
        assertThatThrownBy(callable).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> validMakerName() {
        return Stream.of(
            Arguments.of("a000000000"),
            Arguments.of("b")
        );
    }

    static Stream<Arguments> invalidMakerName() {
        return Stream.of(
            Arguments.of(""),
            Arguments.of((Object) null)
        );
    }

}
