package com.sakak.api.nutrient.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ResearchYear {

    private static final Long MIN_RESEARCH_YEAR = 1900L;

    @Column(nullable = false)
    private Long year;

    private ResearchYear(Long year) {
        this.year = year;
    }

    public static ResearchYear from(Long year) {
        validateResearchYear(year);
        return new ResearchYear(year);
    }

    private static void validateResearchYear(Long year) {
        if (Objects.isNull(year)
            || year < MIN_RESEARCH_YEAR
            && LocalDateTime.now().getYear() < year
        ) {
            throw new IllegalArgumentException("invalid research year");
        }
    }

}
