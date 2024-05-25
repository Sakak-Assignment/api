package com.sakak.api.food.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MakerName {

    @Column(nullable = false)
    private String makerName;

    private MakerName(String makerName) {
        this.makerName = makerName;
    }

    public static MakerName from(String makerName) {
        validateMakerName(makerName);
        return new MakerName(makerName);
    }

    private static void validateMakerName(String makerName) {
        if (Objects.isNull(makerName) || makerName.isEmpty()) {
            throw new IllegalArgumentException("invalid maker makerName");
        }
    }

}
