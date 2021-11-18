package com.abdulsamadsyed.restaurantopeninghours

import com.abdulsamadsyed.restaurantopeninghours.model.input.DaysOfWeek
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DaysOfWeekTest {

    @Test
    fun testDaysOfWeek() {
        assertTrue(DaysOfWeek.valueOf("monday") == DaysOfWeek.monday)
        assertTrue(DaysOfWeek.valueOf("monday").displayName == "Monday")
        assertEquals(DaysOfWeek.values().size, 7)
    }
}
