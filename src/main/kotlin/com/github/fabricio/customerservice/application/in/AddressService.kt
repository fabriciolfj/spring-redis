package com.github.fabricio.customerservice.application.`in`

import com.github.fabricio.customerservice.domain.Address

interface AddressService {

    fun save(address: Address)

    fun find(geocode: String) : Address
}