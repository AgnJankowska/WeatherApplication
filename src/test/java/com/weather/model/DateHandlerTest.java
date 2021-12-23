package com.weather.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

class DateHandlerTest {

    @Test
    void methodShouldCreateProperArrayForTheNextFiveDays() {
        //given
        LocalDate testDate = LocalDate.of(2021, 12, 14);
        DateHandler dateHandler = new DateHandler(testDate);

        //when
        List<String> arrayOfFiveDays = dateHandler.createArrayOfFiveDays();

        //then
        Assertions.assertAll(() -> {
            assertThat(arrayOfFiveDays.get(0), equalTo("wt. \n14.12"));
            assertThat(arrayOfFiveDays.get(1), equalTo("śr. \n15.12"));
            assertThat(arrayOfFiveDays.get(2), equalTo("czw. \n16.12"));
            assertThat(arrayOfFiveDays.get(3), equalTo("pt. \n17.12"));
            assertThat(arrayOfFiveDays.get(4), equalTo("sob. \n18.12"));
            assertThat(arrayOfFiveDays, hasSize(5));
        });
    }
}