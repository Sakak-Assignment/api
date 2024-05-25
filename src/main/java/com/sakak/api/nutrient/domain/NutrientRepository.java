package com.sakak.api.nutrient.domain;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutrientRepository extends JpaRepository<Nutrient, Long> {

    Optional<Nutrient> findByFoodIdAndResearchYear(Long foodId, long researchYear);
}
