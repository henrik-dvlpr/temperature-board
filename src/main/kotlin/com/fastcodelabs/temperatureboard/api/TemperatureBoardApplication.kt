package com.fastcodelabs.temperatureboard.api

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition
import org.eclipse.microprofile.openapi.annotations.info.Info
import javax.ws.rs.core.Application

@OpenAPIDefinition(info = Info(title = "Temperature Board API", version = "1.0"))
class TemperatureBoardApplication : Application()
