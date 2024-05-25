package com.sakak.api.nutrient.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ServingSize {

    @Column(nullable = false)
    private Long size;

    private ServingSize(Long size) {
        this.size = size;
    }

    public static ServingSize from(Long size) {
        validateServingSize(size);
        return new ServingSize(size);
    }

    private static void validateServingSize(Long servingSize) {
        if (Objects.isNull(servingSize) || servingSize <= 0) {
            throw new IllegalArgumentException("invalid serving size");
        }
    }

}
