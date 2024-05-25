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
public class GroupName {

    @Column(nullable = false)
    private String name;

    private GroupName(String name) {
        this.name = name;
    }

    public static GroupName from(String name) {
        validateGroupName(name);
        return new GroupName(name);
    }

    private static void validateGroupName(String makerName) {
        if (Objects.isNull(makerName) || makerName.isEmpty()) {
            throw new IllegalArgumentException("invalid group name");
        }
    }

}
