package com.weather.model;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;

class DateHandlerTest {

    @Test
    void methodShouldCreateProperArrayForTheNextFiveDays() {
        //given
        DateHandler dateHandler = new DateHandler();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E \ndd.MM");

        //when
        List<String> arrayOfFiveDays = dateHandler.createArrayOfFiveDays();

        //then
        assertThat(arrayOfFiveDays, contains(
                localDate.format(formatter),
                localDate.plusDays(1).format(formatter),
                localDate.plusDays(2).format(formatter),
                localDate.plusDays(3).format(formatter),
                localDate.plusDays(4).format(formatter))
        );
        assertThat(arrayOfFiveDays, hasSize(5));
    }
}