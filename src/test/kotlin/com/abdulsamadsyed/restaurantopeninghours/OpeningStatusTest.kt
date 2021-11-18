package com.abdulsamadsyed.restaurantopeninghours

import com.abdulsamadsyed.restaurantopeninghours.model.input.OpeningStatus
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
