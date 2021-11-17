package com.abdulsamadsyed.resturantopeninghours

import com.abdulsamadsyed.resturantopeninghours.model.OpeningHoursDay
import com.abdulsamadsyed.resturantopeninghours.model.input.DaysOfWeek
import com.abdulsamadsyed.resturantopeninghours.model.input.OpeningStatus
import com.abdulsamadsyed.resturantopeninghours.transformer.OutputResultTransform
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class OutputResultTransformTest {

    @Test
    fun testOutput() {
        val outputResultTransform = OutputResultTransform()
        val expected = "Monday: 5 AM - 7 PM\n" +
            "Tuesday: 6:48 AM - 4:40 PM\n" +
            "Wednesday: Closed\n" +
            "Thursday: 9:30 AM - 10:43 AM\n" +
            "Friday: Closed\n" +
            "Saturday: Closed\n" +
            "Sunday: 1:53 PM - 7 PM"
        val outputString = outputResultTransform.transformToOutput(getDummyInput())
        Assertions.assertEquals(expected, outputString)
    }

    private fun getDummyInput(): Map<DaysOfWeek, List<OpeningHoursDay>> {
        val mondayHours = listOf(OpeningHoursDay(DaysOfWeek.monday, OpeningStatus.open, 18000), OpeningHoursDay(DaysOfWeek.monday, OpeningStatus.close, 68400))
        val tuesdayHours = listOf(OpeningHoursDay(DaysOfWeek.tuesday, OpeningStatus.open, 24500), OpeningHoursDay(DaysOfWeek.tuesday, OpeningStatus.close, 60000))
        val thursdayHours = listOf(OpeningHoursDay(DaysOfWeek.thursday, OpeningStatus.open, 34200), OpeningHoursDay(DaysOfWeek.thursday, OpeningStatus.close, 38600))
        val sundayHours = listOf(OpeningHoursDay(DaysOfWeek.sunday, OpeningStatus.open, 50000), OpeningHoursDay(DaysOfWeek.sunday, OpeningStatus.close, 68400))
        return mapOf(
            DaysOfWeek.monday to mondayHours,
            DaysOfWeek.tuesday to tuesdayHours,
            DaysOfWeek.thursday to thursdayHours,
            DaysOfWeek.sunday to sundayHours
        )
    }
}
