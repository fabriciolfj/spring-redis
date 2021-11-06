package com.github.fabricio.customerservice.domain


data class Customer(val name: String,
                    val document: String,
                    var addresses: List<Address>)