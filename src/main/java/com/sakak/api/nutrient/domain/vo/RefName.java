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
public class RefName {

    @Column(nullable = false)
    private String name;

    private RefName(String name) {
        this.name = name;
    }

    public static RefName from(String name) {
        validateRefName(name);
        return new RefName(name);
    }

    private static void validateRefName(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException("invalid ref name");
        }
    }

}
