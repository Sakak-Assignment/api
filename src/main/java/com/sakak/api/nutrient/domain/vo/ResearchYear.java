package com.sakak.api.nutrient.domain.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ResearchYear {

    private static final long MIN_RESEARCH_YEAR = 1900L;

    @Column(nullable = false)
    private long year;

    private ResearchYear(long year) {
        this.year = year;
    }

    public static ResearchYear from(long year) {
        validateResearchYear(year);
        return new ResearchYear(year);
    }

    private static void validateResearchYear(long year) {
        if (year < MIN_RESEARCH_YEAR && LocalDateTime.now().getYear() < year) {
            throw new IllegalArgumentException("invalid research year");
        }
    }

}