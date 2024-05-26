DROP TABLE IF EXISTS food CASCADE;
DROP TABLE IF EXISTS nutrient CASCADE;

CREATE TABLE food (
                      id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                      food_code VARCHAR(255) NOT NULL,
                      food_name VARCHAR(255) NOT NULL,
                      group_name VARCHAR(255) NOT NULL,
                      maker_name VARCHAR(255) NOT NULL
);

CREATE TABLE nutrient (
                          id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
                          carbohydrate NUMERIC(38, 2) NOT NULL,
                          cholesterol NUMERIC(38, 2) NOT NULL,
                          calorie NUMERIC(38, 2) NOT NULL,
                          protein NUMERIC(38, 2) NOT NULL,
                          province NUMERIC(38, 2) NOT NULL,
                          salt NUMERIC(38, 2) NOT NULL,
                          saturated_fatty_acids NUMERIC(38, 2) NOT NULL,
                          sugars NUMERIC(38, 2) NOT NULL,
                          trans_fat NUMERIC(38, 2) NOT NULL,
                          food_id BIGINT NOT NULL,
                          research_year BIGINT NOT NULL,
                          serving_size BIGINT NOT NULL,
                          ref_name VARCHAR(255) NOT NULL
);
