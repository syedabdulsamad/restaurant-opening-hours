package com.abdulsamadsyed.restaurantopeninghours.controller

import com.abdulsamadsyed.restaurantopeninghours.model.input.OpeningHoursInputRequest
import com.abdulsamadsyed.restaurantopeninghours.service.OpeningHoursService
import com.abdulsamadsyed.restaurantopeninghours.transformer.InputRequestTransformer
import com.abdulsamadsyed.restaurantopeninghours.transformer.OutputResultTransform
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OpeningHoursController(
    val inputTransformer: InputRequestTransformer,
    val openingHoursService: OpeningHoursService,
    val outputResultTransform: OutputResultTransform
) {

    @PostMapping("/opening-hours-converter")
    fun convertOpeningHours(@Validated @RequestBody openingHoursInput: OpeningHoursInputRequest): String {
        val transformInput = inputTransformer.transformInputRequest(openingHoursInput)
        val openingHours = openingHoursService.getOpeningHours(transformInput)
        val result = outputResultTransform.transformToOutput(openingHours)
        result.apply { println(this) }
        return result
    }
}
