package com.fastcodelabs.temperatureboard.api.port

import com.fastcodelabs.temperatureboard.api.domain.CapitalCity
import com.fastcodelabs.temperatureboard.api.domain.Temperature

interface TemperatureClient {

    fun getByCapitalCity(capitalCity: CapitalCity): Temperature

}
