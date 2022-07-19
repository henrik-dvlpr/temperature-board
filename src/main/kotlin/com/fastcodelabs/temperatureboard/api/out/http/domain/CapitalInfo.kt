package com.fastcodelabs.temperatureboard.api.out.http.domain

import com.fasterxml.jackson.annotation.JsonProperty

data class CapitalInfo(
    @JsonProperty("latlng") val latitudeAndLongitude: List<Double>? // Hint: first entry in the list is the latitude
)
