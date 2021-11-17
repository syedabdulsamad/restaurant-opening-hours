package com.abdulsamadsyed.resturantopeninghours.IT

import com.abdulsamadsyed.resturantopeninghours.ResturantOpeningHoursApplication
import com.abdulsamadsyed.resturantopeninghours.ResturantOpeningHoursApplicationTests
import com.abdulsamadsyed.resturantopeninghours.controller.OpeningHoursController
import com.abdulsamadsyed.resturantopeninghours.service.OpeningHoursService
import com.abdulsamadsyed.resturantopeninghours.transformer.InputRequestTransformer
import com.abdulsamadsyed.resturantopeninghours.transformer.OutputResultTransform
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.http.RequestEntity.get
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

//@ExtendWith(SpringExtension::class)
//@WebMvcTest(controllers = [OpeningHoursController::class])

@ExtendWith(SpringExtension::class)
@SpringBootTest
@AutoConfigureMockMvc

class OpeningHoursIT {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var inputRequestTransformer: InputRequestTransformer
    @Autowired
    private lateinit var openingHoursService: OpeningHoursService
    @Autowired
    private lateinit var outputResultTransform: OutputResultTransform

    @Test
    @DisplayName("Test the endpoint with request to get opening hours")
    fun testGetOpeningHours() {
        val expectedResult = "Monday: Closed\n" +
                "Tuesday: 10 AM - 6 PM\n" +
                "Wednesday: Closed\n" +
                "Thursday: 10:30 AM - 6 PM, 7 PM - 11 PM\n" +
                "Friday: 10 AM - 1 AM\n" +
                "Saturday: 10 AM - 1 AM\n" +
                "Sunday: 12 PM - 9 PM, 11 PM - 6 PM"


        val result = mockMvc.perform(MockMvcRequestBuilders.get("/opening-hours")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody())
        ).andExpect(status().isOk)
                .andReturn()
        assertEquals(result.response.contentAsString, expectedResult)
    }

    private fun requestBody() = """{
	"monday": [{
        "type" : "close",
		"value": 64800
    }],
	"tuesday": [{
		"type": "open",
		"value": 36000
	}, {
		"type" : "close",
		"value": 64800
	}],
	"wednesday": [],
	"thursday": [{
			"type": "open",
			"value": 37800
		},
		{
			"type": "close",
			"value": 64800
		},
        {
			"type": "open",
			"value": 68400
		},
		{
			"type": "close",
			"value": 82800
		}
	],
	"friday": [{
		"type": "open",
		"value": 36000
	}],
	"saturday": [{
			"type": "close",
			"value": 3600
		},
		{
			"type": "open",
			"value": 36000
		}
	],
	"sunday": [{
			"type": "close",
			"value": 3600
		},
		{
			"type": "open",
			"value": 43200
		},
		{
			"type": "close",
			"value": 75600
		},
        {
			"type": "open",
			"value": 82800
		}
	]
}
"""
}