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
    private long researchYear;

    private ResearchYear(long researchYear) {
        this.researchYear = researchYear;
    }

    public static ResearchYear from(long researchYear) {
        validateResearchYear(researchYear);
        return new ResearchYear(researchYear);
    }

    private static void validateResearchYear(long researchYear) {
        if (researchYear < MIN_RESEARCH_YEAR || LocalDateTime.now().getYear() < researchYear) {
            throw new IllegalArgumentException("invalid research year");
        }
    }

}
