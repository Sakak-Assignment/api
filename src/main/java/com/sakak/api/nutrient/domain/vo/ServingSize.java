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
    private long size;

    private ServingSize(long size) {
        this.size = size;
    }

    public static ServingSize from(long size) {
        validateServingSize(size);
        return new ServingSize(size);
    }

    private static void validateServingSize(long servingSize) {
        if (servingSize <= 0) {
            throw new IllegalArgumentException("invalid serving size");
        }
    }

}
