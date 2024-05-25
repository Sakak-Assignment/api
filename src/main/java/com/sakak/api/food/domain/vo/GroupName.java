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
    private String groupName;

    private GroupName(String groupName) {
        this.groupName = groupName;
    }

    public static GroupName from(String groupName) {
        validateGroupName(groupName);
        return new GroupName(groupName);
    }

    private static void validateGroupName(String groupName) {
        if (Objects.isNull(groupName) || groupName.isEmpty()) {
            throw new IllegalArgumentException("invalid group name");
        }
    }

}
