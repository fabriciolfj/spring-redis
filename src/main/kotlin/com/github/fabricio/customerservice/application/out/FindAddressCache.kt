package com.github.fabricio.customerservice.application.out

import com.github.fabricio.customerservice.domain.Address

interface FindAddressCache {

    fun find(geocode: String) : Address
}