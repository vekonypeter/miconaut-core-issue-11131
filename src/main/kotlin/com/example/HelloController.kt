package com.example

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow

@Controller("/hello")
class HelloController {

    @Get(value = "/world1")
    suspend fun world1(): Flow<String> {
        delay(1000)
        return listOf("Hello World").asFlow()
    }

    @Get(value = "/world2", produces = [MediaType.TEXT_PLAIN])
    suspend fun world2(): Flow<String> = flow {
        delay(1000)
        listOf("Hello World").forEach { emit(it) }
    }
}
