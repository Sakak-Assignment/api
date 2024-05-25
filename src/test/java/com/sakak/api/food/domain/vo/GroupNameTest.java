package com.sakak.api.food.domain.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GroupNameTest {

    @ParameterizedTest
    @MethodSource("validGroupName")
    void 식품_상세분류를_정상적으로_생성한다(String groupName) {
        //given when
        GroupName validGroupName = GroupName.from(groupName);

        //then
        assertThat(validGroupName.getName()).isEqualTo(groupName);
    }

    @ParameterizedTest
    @MethodSource("invalidGroupName")
    void 식품_상세분류_생성에_실패한다(String groupName) {
        //given when
        ThrowingCallable callable = () -> GroupName.from(groupName);

        //then
        assertThatThrownBy(callable).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> validGroupName() {
        return Stream.of(
            Arguments.of("a"),
            Arguments.of("bb")
        );
    }

    static Stream<Arguments> invalidGroupName() {
        return Stream.of(
            Arguments.of(""),
            Arguments.of((Object) null)
        );
    }

}
