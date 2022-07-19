package com.fastcodelabs.temperatureboard.api.lifecycle

import com.fastcodelabs.temperatureboard.api.domain.CapitalCity
import com.fastcodelabs.temperatureboard.api.domain.Temperature
import com.fastcodelabs.temperatureboard.api.port.CapitalCityClient
import com.fastcodelabs.temperatureboard.api.port.TemperatureClient
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class CapitalCityTemperatures(
    @Inject private val capitalCityClient: CapitalCityClient,
    @Inject private val temperatureClient: TemperatureClient
) {

    fun findData(): Map<CapitalCity, Temperature> {
        val dataMap = HashMap<CapitalCity, Temperature>()

        val capitalCities = capitalCityClient.findAll()
        capitalCities.forEach {
            val temperature = temperatureClient.getByCapitalCity(it)
            dataMap[it] = temperature
        }

        return dataMap
    }

}
