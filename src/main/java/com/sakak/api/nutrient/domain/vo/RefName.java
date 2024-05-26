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
    private String refName;

    private RefName(String refName) {
        this.refName = refName;
    }

    public static RefName from(String refName) {
        validateRefName(refName);
        return new RefName(refName);
    }

    private static void validateRefName(String refName) {
        if (Objects.isNull(refName) || refName.isEmpty()) {
            throw new IllegalArgumentException("invalid ref name");
        }
    }

}
