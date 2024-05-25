package com.sakak.api.food.presentation;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

import com.sakak.api.DatabaseCleanup;
import com.sakak.api.food.FoodFixture;
import com.sakak.api.food.domain.Food;
import com.sakak.api.food.domain.FoodRepository;
import com.sakak.api.nutrient.domain.Nutrient;
import com.sakak.api.nutrient.domain.NutrientRepository;
import com.sakak.api.nutrient.domain.vo.NutrientFixture;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FoodControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private DatabaseCleanup databaseCleanup;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private NutrientRepository nutrientRepository;


    @BeforeEach
    public void setUp() {
        RestAssured.port = port;
    }

    @AfterEach
    public void tearDown() {
        databaseCleanup.execute();
    }

    @Test
    void 식품의_영양소_정보를_조회한다() {
        // given
        Food savedFood = foodRepository.save(FoodFixture.createFood());
        Nutrient savedNutrient = nutrientRepository.save(NutrientFixture.createNutrient(savedFood));

        // when
        ExtractableResponse<Response> response = given().log().all()
            .when()
//            .queryParam("food_code", savedFood.getFoodCode())
            .queryParam("food_code", "aaaaaa")
            .queryParam("food_name", savedFood.getFoodName())
            .queryParam("maker_name", savedFood.getMakerName())
            .queryParam("research_year", savedNutrient.getResearchYear())
            .get("/foods/nutrients")
            .then().log().all()
            .extract();

        // then
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

}
