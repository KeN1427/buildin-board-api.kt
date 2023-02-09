package com.ken1427.buildinboardapi.kt

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
class HtmlController {
    @GetMapping("/healthCheck")
    @Operation(summary = "health check")
    fun healthCheck(
        @Parameter(description = "your name", required = false)
        @RequestParam(value = "name", defaultValue = "world")
        name: String
    ): String {
        return "hello, $name!"
    }
}