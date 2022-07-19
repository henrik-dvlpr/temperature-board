package com.fastcodelabs.temperatureboard.api.out

import com.fastcodelabs.temperatureboard.api.domain.CapitalCity
import com.fastcodelabs.temperatureboard.api.domain.Temperature
import com.fastcodelabs.temperatureboard.api.domain.TemperatureUnit
import com.fastcodelabs.temperatureboard.api.out.http.HttpTemperatureClient
import com.fastcodelabs.temperatureboard.api.port.TemperatureClient
import org.eclipse.microprofile.config.inject.ConfigProperty
import org.eclipse.microprofile.rest.client.inject.RestClient
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class TemperatureClientImpl(
    @RestClient private val httpTemperatureClient: HttpTemperatureClient,
    @ConfigProperty(name = "temperature.client.http.api-key") private val apiKey: String
) : TemperatureClient {

    override fun getByCapitalCity(capitalCity: CapitalCity): Temperature {
        val temperatureResponse = httpTemperatureClient.getByLatitudeAndLongitude(
            capitalCity.latitude,
            capitalCity.longitude,
            TemperatureUnit.METRIC.name,
            apiKey
        )

        return Temperature(temperatureResponse.main.temp, TemperatureUnit.METRIC)
    }

}
