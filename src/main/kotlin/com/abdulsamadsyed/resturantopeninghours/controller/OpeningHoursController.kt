package com.abdulsamadsyed.resturantopeninghours.controller

import com.abdulsamadsyed.resturantopeninghours.model.input.OpeningHoursInputRequest
import com.abdulsamadsyed.resturantopeninghours.service.OpeningHoursService
import com.abdulsamadsyed.resturantopeninghours.transformer.InputRequestTransformer
import com.abdulsamadsyed.resturantopeninghours.transformer.OutputResultTransform
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class OpeningHoursController(
    val inputTransformer: InputRequestTransformer,
    val openingHoursService: OpeningHoursService,
    val outputResultTransform: OutputResultTransform
) {

    @GetMapping("/opening-hours")
    fun getOpeningHours(@Validated @RequestBody openingHoursInput: OpeningHoursInputRequest): String {
        val transformInput = inputTransformer.transformInput(openingHoursInput)
        val openingHours = openingHoursService.getOpeningHours(transformInput)
        val result = outputResultTransform.transformToOutput(openingHours)
        result.apply { println(this) }
        return result
    }
}
