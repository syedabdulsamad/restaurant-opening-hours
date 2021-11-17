package com.abdulsamadsyed.resturantopeninghours

import com.abdulsamadsyed.resturantopeninghours.model.input.DaysOfWeek
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DaysOfWeekTest {

    @Test
    fun testDaysOfWeek() {

        Assertions.assertTrue(DaysOfWeek.valueOf("monday") == DaysOfWeek.monday)
    }
}
