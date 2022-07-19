package com.fastcodelabs.temperatureboard.api.out

import com.fastcodelabs.temperatureboard.api.domain.CapitalCity
import com.fastcodelabs.temperatureboard.api.out.http.HttpCapitalCityClient
import com.fastcodelabs.temperatureboard.api.out.http.domain.CapitalCityResponse
import com.fastcodelabs.temperatureboard.api.port.CapitalCityClient
import org.eclipse.microprofile.rest.client.inject.RestClient
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.inject.Qualifier

@ApplicationScoped
class CapitalCityClientImpl(
    @RestClient private val httpCapitalCityClient: HttpCapitalCityClient
) : CapitalCityClient {

    override fun findAll(): List<CapitalCity> {
        val capitalCities = ArrayList<CapitalCity>()
        val capitalCityResponses = httpCapitalCityClient.findAll()
        capitalCityResponses.forEach {
            if (it.capitalInfo.latitudeAndLongitude == null) {
                print("Country without capital ?")
            } else {
                capitalCities.add(mapFrom(it))
            }
        }
        return capitalCities
    }

    private fun mapFrom(capitalCityResponse: CapitalCityResponse): CapitalCity {
        return CapitalCity(
            capitalCityResponse.name.common,
            capitalCityResponse.capital!![0],
            capitalCityResponse.capitalInfo.latitudeAndLongitude!![0],
            capitalCityResponse.capitalInfo.latitudeAndLongitude[1]
        )
    }

}
