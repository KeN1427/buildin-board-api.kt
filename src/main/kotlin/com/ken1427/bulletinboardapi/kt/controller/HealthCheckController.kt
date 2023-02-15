package com.ken1427.bulletinboardapi.kt.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class HealthCheckController {
    @GetMapping(path = ["/healthCheck"])
    @Operation(summary = "Health check")
    fun healthCheck(
        @RequestParam(value = "name", defaultValue = "world", required = false)
        @Parameter(description = "Your name", example = "Bob")
        name: String
    ): ResponseEntity<String> {
        return ResponseEntity("hello, $name! Health check succeeded.", HttpStatus.OK)
    }
}