package com.github.fabricio.customerservice.application.`in`

import com.github.fabricio.customerservice.domain.Customer

interface CustomerService {

    fun save(customer: Customer)

    fun find(document: String):  Customer
}