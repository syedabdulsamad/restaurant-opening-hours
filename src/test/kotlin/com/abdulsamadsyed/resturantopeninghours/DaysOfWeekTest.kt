package com.abdulsamadsyed.resturantopeninghours

import com.abdulsamadsyed.resturantopeninghours.model.input.DaysOfWeek
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
