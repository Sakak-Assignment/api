package com.sakak.api.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class FoodCode {

    @Column(nullable = false)
    public String code;

    private FoodCode(String code) {
        this.code = code;
    }

    public static FoodCode from(String code) {
        validateCodeForm(code);
        return new FoodCode(code);
    }

    private static void validateCodeForm(String code) {
        if (Objects.isNull(code) || !Character.isAlphabetic(code.charAt(0))) {
            throw new IllegalArgumentException("invalid code form");
        }
    }

}
