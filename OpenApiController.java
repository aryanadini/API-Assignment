package com.springboot.app;

import javax.print.Doc;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.RequestHandledEvent;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.ranges.DocumentRange;

@RestController
@RequestMapping("/api")
public class OpenApiController {

    @GetMapping("/weather")
    public ResponseEntity<WeatherResponse> getWeatherData(@RequestParam("city") String city) {
        // Authenticate the user using JWT to ensure authorized access

        // Call the external API to fetch weather data for the given city
        WeatherResponse response = fetchWeatherDataFromExternalApi(city);

        return ResponseEntity.ok(response);
    }

    private WeatherResponse fetchWeatherDataFromExternalApi(String city) {
		return null;
        // Implement the logic to fetch weather data from the external API
        // Return the response
    }
   
    
}

