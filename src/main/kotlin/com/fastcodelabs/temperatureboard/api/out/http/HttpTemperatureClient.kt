package com.fastcodelabs.temperatureboard.api.out.http

import com.fastcodelabs.temperatureboard.api.out.http.domain.TemperatureResponse
import com.fastcodelabs.temperatureboard.api.port.TemperatureClient
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.QueryParam
import javax.ws.rs.core.MediaType

@RegisterRestClient
@Consumes(MediaType.APPLICATION_JSON)
@Path("/data/2.5")
interface HttpTemperatureClient {

    @Path("/weather")
    @GET
    fun getByLatitudeAndLongitude(
        @QueryParam("lat") latitude: Double,
        @QueryParam("lon") longitude: Double,
        @QueryParam("units") units: String,
        @QueryParam("appid") apiKey: String
    ): TemperatureResponse

}
