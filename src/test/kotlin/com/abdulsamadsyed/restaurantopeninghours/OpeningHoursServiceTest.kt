package com.abdulsamadsyed.restaurantopeninghours

import com.abdulsamadsyed.restaurantopeninghours.model.OpeningHoursDay
import com.abdulsamadsyed.restaurantopeninghours.model.input.DaysOfWeek
import com.abdulsamadsyed.restaurantopeninghours.model.input.OpeningStatus
import com.abdulsamadsyed.restaurantopeninghours.service.OpeningHoursService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class OpeningHoursServiceTest {
    @Test
    @DisplayName("Test service to return opening hours of given days.")
    fun testGetOpeningHours() {
        val service = OpeningHoursService()
        val openingHours = service.getOpeningHours(dummyOpeningHours())
        assertEquals(openingHours.size, 3)
    }

    @Test
    @DisplayName("Test service to return opening hours of given days when closing hours span multiple days.")
    fun testGetOpeningHoursSpanningMultipleDays() {
        val service = OpeningHoursService()
        val openingHours = service.getOpeningHours(
            dummyOpeningHours()
                .plus(OpeningHoursDay(DaysOfWeek.saturday, OpeningStatus.open, 82800))
                .plus(OpeningHoursDay(DaysOfWeek.sunday, OpeningStatus.close, 18000))
        )
        assertEquals(openingHours.size, 3)
        assertEquals(openingHours[DaysOfWeek.saturday]?.size, 4)
        assertNull(openingHours[DaysOfWeek.monday])
        assertNull(openingHours[DaysOfWeek.sunday])
    }

    @Test
    @DisplayName("Test service to return opening hours of given days when week strats with closing.")
    fun testGetOpeningHoursWeekStartWithClosing() {
        val service = OpeningHoursService()
        val openingHours = service.getOpeningHours(
            listOf(OpeningHoursDay(DaysOfWeek.monday, OpeningStatus.close, 18000))
                .plus(dummyOpeningHours())
                .plus(OpeningHoursDay(DaysOfWeek.sunday, OpeningStatus.open, 82800))
        )
        assertEquals(openingHours.size, 4)
        assertEquals(openingHours[DaysOfWeek.saturday]?.size, 2)
        assertEquals(openingHours[DaysOfWeek.sunday]?.size, 2)
        assertNull(openingHours[DaysOfWeek.monday])
    }

    private fun dummyOpeningHours() = listOf(
        OpeningHoursDay(DaysOfWeek.tuesday, OpeningStatus.open, 24500),
        OpeningHoursDay(DaysOfWeek.tuesday, OpeningStatus.close, 60000),
        OpeningHoursDay(DaysOfWeek.tuesday, OpeningStatus.open, 68000),
        OpeningHoursDay(DaysOfWeek.tuesday, OpeningStatus.close, 80000),
        OpeningHoursDay(DaysOfWeek.thursday, OpeningStatus.open, 34200),
        OpeningHoursDay(DaysOfWeek.thursday, OpeningStatus.close, 38600),
        OpeningHoursDay(DaysOfWeek.saturday, OpeningStatus.open, 50000),
        OpeningHoursDay(DaysOfWeek.saturday, OpeningStatus.close, 68400)
    )
}
