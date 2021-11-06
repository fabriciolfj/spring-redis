package com.github.fabricio.customerservice.adapter.`in`

import com.github.fabricio.customerservice.application.`in`.AddressService
import com.github.fabricio.customerservice.domain.Address
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/address")
class AddressController {

    @Autowired
    private lateinit var addressService: AddressService

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody address: Address) {
        addressService.save(address)
    }

    @GetMapping("/{geocode}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun find(@PathVariable("geocode") geocode: String) = addressService.find(geocode)
}