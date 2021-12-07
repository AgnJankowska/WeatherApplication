package com.weather.model.weatherCondition;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class DescriptionOfConditionTest {

    @Test
    void creatingObjectShouldInitializeArrayOfConditions() {
        //given
        DescriptionOfCondition descriptionOfCondition = new DescriptionOfCondition();

        //when & then
        assertThat(descriptionOfCondition.getArrayOfCondition(), is(notNullValue()));
        assertThat(descriptionOfCondition.getArrayOfCondition(), hasSize(54));
    }

    @Test
    void creatingOtherObjectShouldNotHaveInfluenceOnArrayOfConditions() {
        //given
        DescriptionOfCondition descriptionOfCondition1 = new DescriptionOfCondition();
        DescriptionOfCondition descriptionOfCondition2 = new DescriptionOfCondition();

        //when & then
        assertThat(descriptionOfCondition1.getArrayOfCondition(), hasSize(54));
        assertThat(descriptionOfCondition2.getArrayOfCondition(), hasSize(54));
        assertThat(descriptionOfCondition2.getArrayOfCondition(), not(sameInstance(descriptionOfCondition1.getArrayOfCondition())));
    }

    @Test
    void CorrectIdShouldReturnTrue() {
        //given
        DescriptionOfCondition descriptionOfCondition = new DescriptionOfCondition();

        //when
        boolean result = descriptionOfCondition.idIsCorrect(800);

        //then
        assertThat(result, is(true));

    }

    @Test
    void IncorrectIdShouldReturnFalse() {
        //given
        DescriptionOfCondition descriptionOfCondition = new DescriptionOfCondition();

        //when
        boolean result = descriptionOfCondition.idIsCorrect(1);

        //then
        assertThat(result, is(false));
    }

}