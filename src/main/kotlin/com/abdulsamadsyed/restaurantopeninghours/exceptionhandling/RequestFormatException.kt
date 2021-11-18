package com.abdulsamadsyed.restaurantopeninghours.exceptionhandling

data class RequestFormatException(override val message: String) : Exception(message)
