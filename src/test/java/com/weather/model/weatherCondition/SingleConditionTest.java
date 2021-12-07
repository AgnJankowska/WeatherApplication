package com.weather.model.weatherCondition;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

class SingleConditionTest {

    @Test
    void constructorShouldCreateSingleConditionObject() {
        //given
        int id = 800;
        MainCondition main = MainCondition.CLEAR;
        String description = "czyste niebo";

        //when
        SingleCondition singleCondition = new SingleCondition(id, main, description);

        //then
        assertThat(singleCondition, is(notNullValue()));
        assertThat(singleCondition.getId(), equalTo(800));
        assertThat(singleCondition.getMain(), equalTo(MainCondition.CLEAR));
    }
}