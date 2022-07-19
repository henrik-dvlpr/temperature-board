package com.fastcodelabs.temperatureboard.api.out.http.domain

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class CapitalCityResponse(
    val name: CapitalCityCountryName,
    val capital: List<String>?,
    val capitalInfo: CapitalInfo
)
