package com.fastcodelabs.temperatureboard.api.out.http

import com.fastcodelabs.temperatureboard.api.out.http.domain.CapitalCityResponse
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.core.MediaType

@RegisterRestClient
@Consumes(MediaType.APPLICATION_JSON)
@Path("/v3.1")
interface HttpCapitalCityClient {

    @Path("/all")
    @GET
    fun findAll(): List<CapitalCityResponse>
}
