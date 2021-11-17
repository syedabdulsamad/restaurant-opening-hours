package com.abdulsamadsyed.resturantopeninghours.model.input

import com.fasterxml.jackson.annotation.JsonProperty

open class OpeningHours(
    @JsonProperty("type") open val status: OpeningStatus,
    @JsonProperty("value") open val seconds: Int
)
