package com.abdulsamadsyed.restaurantopeninghours.exceptionhandling

import java.util.Date

data class ErrorDetail(val message: String, val details: String, val timestamp: Date)
