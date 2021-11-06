package com.github.fabricio.customerservice.application.out

import com.github.fabricio.customerservice.domain.Customer

interface PutCustomerCache {

    fun create(customer: Customer)
}