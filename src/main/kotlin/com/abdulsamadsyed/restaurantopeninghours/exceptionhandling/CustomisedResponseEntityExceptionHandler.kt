package com.abdulsamadsyed.restaurantopeninghours.exceptionhandling

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.context.request.WebRequest
import java.util.Date

@ResponseBody
@RestController
@ControllerAdvice
class CustomisedResponseEntityExceptionHandler {

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleAllExceptions(ex: Exception, request: WebRequest): ErrorDetail {
        return ErrorDetail(
            message = ex.message ?: "Unknown exception.",
            details = request.getDescription(false),
            timestamp = Date()
        )
    }

    @ExceptionHandler(RequestFormatException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleRequestFormatException(ex: RequestFormatException, request: WebRequest): ErrorDetail {
        return ErrorDetail(
            message = ex.message,
            details = request.getDescription(false),
            timestamp = Date()
        )
    }
}
