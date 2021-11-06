package com.github.fabricio.customerservice.adapter.`in`

import com.github.fabricio.customerservice.application.`in`.AggregateService
import com.github.fabricio.customerservice.domain.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/aggregate")
class AggregateController {

    @Autowired
    private lateinit var aggregateService: AggregateService

    @PutMapping("/{document}/{geocode}")
    @ResponseStatus(HttpStatus.CREATED)
    fun persist(@PathVariable("document") document : String, @PathVariable("geocode") geocode: String) {
        aggregateService.save(document, geocode)
    }

    @GetMapping("/{document}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun find(@PathVariable("document") document : String) : Customer {
        return aggregateService.find(document)
    }
}