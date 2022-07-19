package com.fastcodelabs.temperatureboard.api.out.rest

import com.fastcodelabs.temperatureboard.api.domain.CapitalCity
import com.fastcodelabs.temperatureboard.api.domain.Temperature
import com.fastcodelabs.temperatureboard.api.lifecycle.CapitalCityTemperatures
import com.fastcodelabs.temperatureboard.api.out.rest.domain.CapitalCityTemperatureDTO
import com.fastcodelabs.temperatureboard.api.out.rest.domain.TemperatureDTO
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@RegisterRestClient
@Produces(MediaType.APPLICATION_JSON)
@Path("/api")
class CapitalCityTemperaturesRestController(
    private val capitalCityTemperatures: CapitalCityTemperatures
) {

    @Path("/")
    @GET
    fun findAll(): List<CapitalCityTemperatureDTO> {
        return mapTo(capitalCityTemperatures.findData())
    }

    private fun mapTo(data: Map<CapitalCity, Temperature>): List<CapitalCityTemperatureDTO> {
        val dataDTO = ArrayList<CapitalCityTemperatureDTO>()
        data.forEach {
            val (capitalCity, temperature) = it
            val temperatureDTO = TemperatureDTO(temperature.value, temperature.unit.name)
            val capitalCityTemperatureDTO = CapitalCityTemperatureDTO(
                capitalCity.countryNameEnglish,
                capitalCity.nameEnglish,
                capitalCity.latitude,
                capitalCity.longitude,
                temperatureDTO
            )
            dataDTO.add(capitalCityTemperatureDTO)
        }
        return dataDTO
    }

}
