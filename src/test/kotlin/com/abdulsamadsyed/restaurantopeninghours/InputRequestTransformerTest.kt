package com.abdulsamadsyed.restaurantopeninghours

import com.abdulsamadsyed.restaurantopeninghours.model.input.DaysOfWeek
import com.abdulsamadsyed.restaurantopeninghours.model.input.OpeningHours
import com.abdulsamadsyed.restaurantopeninghours.model.input.OpeningHoursInputRequest
import com.abdulsamadsyed.restaurantopeninghours.model.input.OpeningStatus
import com.abdulsamadsyed.restaurantopeninghours.transformer.InputRequestTransformer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class InputRequestTransformerTest {

    @Test
    @DisplayName("Test input request formatter")
    fun testTransformInputRequest() {
        val openingHoursOfDay = listOf(
            OpeningHours(OpeningStatus.open, 36000),
            OpeningHours(OpeningStatus.close, 80000)
        )
        val inputRequest = OpeningHoursInputRequest(
            monday = openingHoursOfDay,
            tuesday = openingHoursOfDay,
            wednesday = openingHoursOfDay,
            thursday = emptyList(),
            friday = openingHoursOfDay,
            saturday = emptyList(),
            sunday = emptyList()
        )
        val inputRequestTransformer = InputRequestTransformer()
        val openingHoursDayList = inputRequestTransformer.transformInputRequest(inputRequest)
        assertEquals(openingHoursDayList.size, 8)
        assertEquals(openingHoursDayList.first().day, DaysOfWeek.monday)
        assertEquals(openingHoursDayList.last().day, DaysOfWeek.friday)
    }
}
