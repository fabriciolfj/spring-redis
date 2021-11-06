package com.github.fabricio.customerservice.application.`in`

import com.github.fabricio.customerservice.domain.Customer

interface AggregateService {

    fun save(document: String, geocode: String)

    fun find(document: String) : Customer
}