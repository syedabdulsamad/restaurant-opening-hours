package com.abdulsamadsyed.restaurantopeninghours

import com.abdulsamadsyed.restaurantopeninghours.model.OpeningHoursDay
import com.abdulsamadsyed.restaurantopeninghours.model.input.DaysOfWeek
import com.abdulsamadsyed.restaurantopeninghours.model.input.OpeningStatus
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class OpeningHoursDayTest {

    @Test
    @DisplayName("Test mid hours AM seconds conversion to minutes and seconds")
    fun testMidHoursAMOpeningClosingStringRepresentation() {
        var openingHoursDay = OpeningHoursDay(DaysOfWeek.sunday, OpeningStatus.open, 36900)
        Assertions.assertEquals(openingHoursDay.openingClosingTimeString, "10:15 AM")
        openingHoursDay = OpeningHoursDay(DaysOfWeek.sunday, OpeningStatus.open, 39540)
        Assertions.assertEquals(openingHoursDay.openingClosingTimeString, "10:59 AM")
        openingHoursDay = OpeningHoursDay(DaysOfWeek.sunday, OpeningStatus.open, 2000)
        Assertions.assertEquals(openingHoursDay.openingClosingTimeString, "0:33 AM")
        openingHoursDay = OpeningHoursDay(DaysOfWeek.sunday, OpeningStatus.open, 4620)
        Assertions.assertEquals(openingHoursDay.openingClosingTimeString, "1:17 AM")
        Assertions.assertEquals(openingHoursDay.day, DaysOfWeek.sunday)
        Assertions.assertEquals(openingHoursDay.status, OpeningStatus.open)
    }

    @Test
    @DisplayName("Test Noon seconds conversion to minutes and seconds")
    fun testNoonTimeOpeningClosingStringRepresentation() {
        var openingHoursDay = OpeningHoursDay(DaysOfWeek.sunday, OpeningStatus.open, 43200)
        Assertions.assertEquals(openingHoursDay.openingClosingTimeString, "12 PM")
        openingHoursDay = OpeningHoursDay(DaysOfWeek.sunday, OpeningStatus.open, 43260)
        Assertions.assertEquals(openingHoursDay.openingClosingTimeString, "12:1 PM")
        openingHoursDay = OpeningHoursDay(DaysOfWeek.sunday, OpeningStatus.open, 45420)
        Assertions.assertEquals(openingHoursDay.openingClosingTimeString, "12:37 PM")
        openingHoursDay = OpeningHoursDay(DaysOfWeek.sunday, OpeningStatus.open, 46740)
        Assertions.assertEquals(openingHoursDay.openingClosingTimeString, "12:59 PM")
    }

    @Test
    @DisplayName("Test mid hours after Noon seconds conversion to minutes and seconds")
    fun testMidHoursAfterNoonTimeOpeningClosingStringRepresentation() {
        var openingHoursDay = OpeningHoursDay(DaysOfWeek.sunday, OpeningStatus.open, 77340)
        Assertions.assertEquals(openingHoursDay.openingClosingTimeString, "9:29 PM")
        openingHoursDay = OpeningHoursDay(DaysOfWeek.sunday, OpeningStatus.open, 46860)
        Assertions.assertEquals(openingHoursDay.openingClosingTimeString, "1:1 PM")
        openingHoursDay = OpeningHoursDay(DaysOfWeek.sunday, OpeningStatus.open, 61080)
        Assertions.assertEquals(openingHoursDay.openingClosingTimeString, "4:58 PM")
    }

    @Test
    @DisplayName("Test full hours seconds conversion to minutes and seconds")
    fun testFullHourOpeningClosingStringRepresentation() {
        var openingHoursDay = OpeningHoursDay(DaysOfWeek.sunday, OpeningStatus.open, 3600)
        Assertions.assertEquals(openingHoursDay.openingClosingTimeString, "1 AM")
        openingHoursDay = OpeningHoursDay(DaysOfWeek.sunday, OpeningStatus.open, 43200)
        Assertions.assertEquals(openingHoursDay.openingClosingTimeString, "12 PM")
        openingHoursDay = OpeningHoursDay(DaysOfWeek.sunday, OpeningStatus.open, 82800)
        Assertions.assertEquals(openingHoursDay.openingClosingTimeString, "11 PM")
    }
}
