package com.github.fabricio.customerservice.application.out

import com.github.fabricio.customerservice.domain.Address

interface PutAddressCache {

    fun save(address: Address)
}