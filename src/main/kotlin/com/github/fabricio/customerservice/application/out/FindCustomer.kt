package com.github.fabricio.customerservice.application.out

import com.github.fabricio.customerservice.domain.Customer

interface FindCustomer {

    fun find(document: String): Customer
}