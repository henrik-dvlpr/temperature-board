package com.fastcodelabs.temperatureboard.api.port

import com.fastcodelabs.temperatureboard.api.domain.CapitalCity

interface CapitalCityClient {

    fun findAll(): List<CapitalCity>

}
