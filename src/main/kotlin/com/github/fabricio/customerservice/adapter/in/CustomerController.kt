package com.github.fabricio.customerservice.adapter.`in`

import com.github.fabricio.customerservice.application.`in`.CustomerService
import com.github.fabricio.customerservice.domain.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController {

    @Autowired
    private lateinit var customerService: CustomerService

    @GetMapping("/{document}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun find(@PathVariable("document") document: String) = customerService.find(document)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody customer: Customer) {
        customerService.save(customer)
    }
}