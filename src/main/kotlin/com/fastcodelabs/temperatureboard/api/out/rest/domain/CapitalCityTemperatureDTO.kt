package com.fastcodelabs.temperatureboard.api.out.rest.domain

data class CapitalCityTemperatureDTO(
    val countryNameEnglish: String,
    val nameEnglish: String,
    val latitude: Double,
    val longitude: Double,
    val temperature: TemperatureDTO
)
