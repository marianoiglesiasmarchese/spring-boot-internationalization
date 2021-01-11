package com.example.internationalization.controller

import com.example.internationalization.constant.Route
import com.example.internationalization.service.InternationalizeService
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RestController

@RestController
class InternationalizeController(val internationalizeService: InternationalizeService) {

    @GetMapping(value = [Route.HEADER_BASED_INTERNATIONALIZATION], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getHeaderBasedInternationalization(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) language: String) =
        ResponseEntity.ok(internationalizeService.resolveHeaderBasedRequest(language))

//    @GetMapping(value = [Route.UNSAFE_HEADER_BASED_INTERNATIONALIZATION], produces = [MediaType.APPLICATION_JSON_VALUE])
//    fun getUnsafeHeaderBasedInternationalization(@RequestHeader(HttpHeaders.ACCEPT_LANGUAGE) language: String) =
//        ResponseEntity.ok(internationalizeService.resolveHeaderBasedWithoutLanguageSafety(language))

    @GetMapping(value = [Route.APP_BASED_INTERNATIONALIZATION], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAppBasedInternationalization() =
        ResponseEntity.ok(internationalizeService.resolveRequest())

}

