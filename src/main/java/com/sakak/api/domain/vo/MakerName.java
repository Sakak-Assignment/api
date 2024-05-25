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
public class MakerName {

    @Column(nullable = false)
    private String name;

    private MakerName(String name) {
        this.name = name;
    }

    public static MakerName from(String name) {
        validateMakerName(name);
        return new MakerName(name);
    }

    private static void validateMakerName(String makerName) {
        if (Objects.isNull(makerName) || makerName.isEmpty()) {
            throw new IllegalArgumentException("invalid maker name");
        }
    }

}
