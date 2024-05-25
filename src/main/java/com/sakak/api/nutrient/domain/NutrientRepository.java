package com.sakak.api.nutrient.domain;

import com.sakak.api.nutrient.domain.vo.ResearchYear;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutrientRepository extends JpaRepository<Nutrient, Long> {

    Optional<Nutrient> findByFoodIdAndResearchYear(Long foodId, ResearchYear researchYear);
}
