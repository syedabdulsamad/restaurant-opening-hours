package com.abdulsamadsyed.resturantopeninghours

import com.abdulsamadsyed.resturantopeninghours.model.input.OpeningStatus
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class OpeningStatusTest {

    @Test
    fun testOpeningStatus() {
        assertTrue(OpeningStatus.valueOf("open") == OpeningStatus.open)
        assertEquals(OpeningStatus.values().size, 2)
    }
}
