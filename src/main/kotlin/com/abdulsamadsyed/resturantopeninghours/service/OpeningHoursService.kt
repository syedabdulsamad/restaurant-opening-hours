package com.abdulsamadsyed.resturantopeninghours.service

import com.abdulsamadsyed.resturantopeninghours.model.OpeningHoursDay
import com.abdulsamadsyed.resturantopeninghours.model.input.DaysOfWeek
import com.abdulsamadsyed.resturantopeninghours.model.input.OpeningStatus
import org.springframework.stereotype.Service

@Service
class OpeningHoursService {
    fun getOpeningHours(openingHoursList: List<OpeningHoursDay>): Map<DaysOfWeek, List<OpeningHoursDay>> {
        val openingHours = if(openingHoursList.first().status == OpeningStatus.open) openingHoursList else openingHoursList.drop(1) + openingHoursList.first()
        return openingHours.chunked(2) // get the elements in the pairs of opening and closing times
            .map {
                listOf(
                    it.first(), // handle the case when the opening hours go to multiple days
                    OpeningHoursDay(it.first().day, it.last().status, it.last().seconds)
                )
            }.flatten().groupBy { it.day }
    }
}
