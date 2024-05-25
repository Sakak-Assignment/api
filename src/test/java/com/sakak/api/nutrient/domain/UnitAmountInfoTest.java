package com.sakak.api.nutrient.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.math.BigDecimal;
import java.util.stream.Stream;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UnitAmountInfoTest {

    @ParameterizedTest
    @MethodSource("validUnitAmountInfo")
    void 일회_제공량들을_정상적으로_생성한다(
        double carbohydrate,
        double protein,
        double province,
        double sugars,
        double salt,
        double cholesterol,
        double saturatedFattyAcids,
        double transFat
    ) {
        //given when
        UnitAmountInfo validUnitAmountInfo = UnitAmountInfo.of(
            carbohydrate,
            protein,
            province,
            sugars,
            salt,
            cholesterol,
            saturatedFattyAcids,
            transFat
        );

        //then
        assertAll(
            () -> assertThat(validUnitAmountInfo.getCarbohydrate()).isEqualTo(
                BigDecimal.valueOf(carbohydrate)),
            () -> assertThat(validUnitAmountInfo.getProtein()).isEqualTo(
                BigDecimal.valueOf(protein)),
            () -> assertThat(validUnitAmountInfo.getProvince()).isEqualTo(
                BigDecimal.valueOf(province)),
            () -> assertThat(validUnitAmountInfo.getSugars()).isEqualTo(BigDecimal.valueOf(sugars)),
            () -> assertThat(validUnitAmountInfo.getSalt()).isEqualTo(BigDecimal.valueOf(salt)),
            () -> assertThat(validUnitAmountInfo.getCholesterol()).isEqualTo(
                BigDecimal.valueOf(cholesterol)),
            () -> assertThat(validUnitAmountInfo.getSaturatedFattyAcids()).isEqualTo(
                BigDecimal.valueOf(saturatedFattyAcids)),
            () -> assertThat(validUnitAmountInfo.getTransFat()).isEqualTo(
                BigDecimal.valueOf(transFat))
        );
    }

    @ParameterizedTest
    @MethodSource("invalidUnitAmountInfo")
    void 일회_제공량들_생성에_실패한다(
        double carbohydrate,
        double protein,
        double province,
        double sugars,
        double salt,
        double cholesterol,
        double saturatedFattyAcids,
        double transFat
    ) {
        //given when
        ThrowingCallable callable = () -> UnitAmountInfo.of(
            carbohydrate,
            protein,
            province,
            sugars,
            salt,
            cholesterol,
            saturatedFattyAcids,
            transFat
        );

        //then
        assertThatThrownBy(callable).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> validUnitAmountInfo() {
        return Stream.of(
            Arguments.of(1, 1, 1, 1, 1, 1, 1, 1),
            Arguments.of(100000, 100000, 100000, 100000, 100000, 100000, 100000, 100000)
        );
    }

    static Stream<Arguments> invalidUnitAmountInfo() {
        return Stream.of(
            Arguments.of(-1, -1, -1, -1, -1, -1, -1, -1),
            Arguments.of(100000000, 100000000, 100000000, 100000000, 100000000, 100000000,
                100000000, 100000000)
        );
    }

}
