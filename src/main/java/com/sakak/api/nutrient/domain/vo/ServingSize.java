package com.sakak.api.nutrient.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ServingSize {

    @Column(nullable = false)
    private long servingSize;

    private ServingSize(long servingSize) {
        this.servingSize = servingSize;
    }

    public static ServingSize from(long servingSize) {
        validateServingSize(servingSize);
        return new ServingSize(servingSize);
    }

    private static void validateServingSize(long servingSize) {
        if (servingSize <= 0) {
            throw new IllegalArgumentException("invalid serving servingSize");
        }
    }

}
